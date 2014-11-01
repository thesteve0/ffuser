package com.openshift.ff.ws;


import com.google.gson.Gson;
import com.openshift.ff.data.UsersEntity;
import io.iron.ironmq.Client;
import io.iron.ironmq.Cloud;
import io.iron.ironmq.Queue;

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

    //For database work
    @PersistenceContext(name = "users")
    EntityManager em;

    Queue newUserQueue;

    public UserWS() {
        //for MessageQue
        Client client = new Client(System.getenv("OPENSHIFT_IRONMQ_PROJECT"), System.getenv("OPENSHIFT_IRONMQ_TOKEN"), Cloud.ironAWSUSEast);
        newUserQueue = client.queue("added_new_user");

    }


    //for any JSON work we need to do
    Gson gson = new Gson();

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

        System.out.println(System.getenv("OPENSHIFT_IRONMQ_PROJECT"));
        try {
            em.persist(user);
            newUserQueue.push(gson.toJson(user));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;

    }




}
