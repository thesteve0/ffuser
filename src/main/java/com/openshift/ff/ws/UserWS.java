package com.openshift.ff.ws;

import com.openshift.ff.data.UsersEntity;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spousty on 10/24/14.
 */

@RequestScoped
@Stateless
@Path("/")
public class UserWS {

    @PersistenceContext(name = "users")
    EntityManager em;

    @GET
    @Produces("application/json")
    public List<UsersEntity> getAllUsers(){
        List<UsersEntity> users = new ArrayList<UsersEntity>();

        Query query = em.createQuery("select u from UsersEntity u");

        users = (ArrayList<UsersEntity>) query.getResultList();

        return users;
    }

    @GET
    @Produces("application/json")
    @Path("{id}")
    public UsersEntity getAUserById(@PathParam("id") String id){

        Query query = em.createQuery("select u from UsersEntity u where usersid = " + id);

        return (UsersEntity) query.getSingleResult();

    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public UsersEntity addUser(UsersEntity user){

        em.persist(user);

        return user;

    }




}
