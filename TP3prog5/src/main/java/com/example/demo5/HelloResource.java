package com.example.demo5;
import DAO.dao;

import Model.livre;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/hello-world")
public class HelloResource {
    DAO.dao dao=new dao();
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<livre> list() {
        return dao.GetAllProduits();
    }

    @Path("/listbyid/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public livre listbyid(@PathParam("id")int id) {
        return dao.GetLivretByID(id);
    }


    @Path("/inserti")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(livre livre) {
        System.out.println("hello wior");
        dao.insert(livre);
        return "succed";

    }
    @Path("/delete/{id}")
    @DELETE
    public void delete(@PathParam("id")int id) {
        dao.delete(id);
    }
    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void update(livre livre) {
        dao.update(livre);

    }
}