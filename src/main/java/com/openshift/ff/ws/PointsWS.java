package com.openshift.ff.ws;

import com.openshift.ff.data.UsersEntity;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.HashMap;

/**
 * Created by spousty on 11/1/14.
 */

@RequestScoped
@Stateless
@Path("/points")
public class PointsWS {

    //For database work
    @PersistenceContext(name = "users")
    EntityManager em;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("newkill")
    public UsersEntity pointForKill(HashMap justID){

        System.out.println(justID.toString());
        //TODO add a point to the userid
        UsersEntity user = new UsersEntity();
        return user;
    }
}
