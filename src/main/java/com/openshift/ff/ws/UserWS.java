package com.openshift.ff.ws;

import com.openshift.ff.data.UsersEntity;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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




}
