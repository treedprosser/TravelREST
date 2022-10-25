package com.example.travelrest;

import com.google.gson.Gson;
import model.Agent;
import model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * TravelExpertsResource
 * REST Service for retrieving Customer and Agent data from DB
 * James B., Ali H., Trevor P., Evan D.
 * Author: Trevor
 */

@Path("/travel-experts")
public class TravelExpertsResource {

    // Declare variables
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    EntityManager em = factory.createEntityManager();
    Query query;
    Gson gson;
    Customer customer;
    Agent agent;

    @GET
    @Path("/getallcustomers")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCustomers() {
        query = em.createQuery("select c from Customer c");
        List<Customer> customerList = query.getResultList();
        gson = new Gson();
        em.close();
        return gson.toJson(customerList);
    }

    @GET
    @Path("/getcustomer/{ id }")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomer(@PathParam("id") int id) {
        customer = em.find(Customer.class, id);
        gson = new Gson();
        em.close();
        return gson.toJson(customer);
    }

    @PUT
    @Path("/putcustomer")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces(MediaType.APPLICATION_JSON)
    public String putCustomer(String jsonString) {
        gson = new Gson();
        customer = gson.fromJson(jsonString, Customer.class);
        // Begin transaction if Customer data is valid
        if (Validation.isValidCustomer(customer)) {
            em.getTransaction().begin();
            Customer updatedCustomer = em.merge(customer);
            if (updatedCustomer != null) {
                em.getTransaction().commit();
                em.close();
                return "{ message: 'Customer updated successfully' }";
            } else {
                em.getTransaction().rollback();
                em.close();
                return "{ message: 'Customer update failed' }";
            }
        } else {
            return "{ message: 'Invalid Customer Data' }";
        }
    }

    @POST
    @Path("/postcustomer")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces(MediaType.APPLICATION_JSON)
    public String postCustomer(String jsonString) {
        gson = new Gson();
        customer = gson.fromJson(jsonString, Customer.class);
        // Begin transaction if Customer data is valid
        if (Validation.isValidCustomer(customer)) {
            em.getTransaction().begin();
            em.persist(customer);
            if (em.contains(customer)) {
                em.getTransaction().commit();
                em.close();
                return "{ message: 'Customer inserted successfully' }";
            } else {
                em.getTransaction().rollback();
                em.close();
                return "{ message: 'Customer insert failed' }";
            }
        } else {
            return "{ message: 'Invalid Customer Data' }";
        }
    }

    @DELETE
    @Path("/deletecustomer/{ id }")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCustomer(@PathParam("id") int id) {
        customer = em.find(Customer.class, id);
        em.getTransaction().begin();
        em.remove(customer);
        if (em.contains(customer)) {
            em.getTransaction().rollback();
            em.close();
            return "{ message: 'Customer deletion failed' }";
        } else {
            em.getTransaction().commit();
            em.close();
            return "{ message: 'Customer successfully deleted }";
        }
    }

    @GET
    @Path("/getallagents")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllAgents() {
        query = em.createQuery("select a from Agent a");
        List<Agent> agentList = query.getResultList();
        gson = new Gson();
        em.close();
        return gson.toJson(agentList);
    }

    @GET
    @Path("/getagent/{ id }")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAgent(@PathParam("id") int id) {
        agent = em.find(Agent.class, id);
        gson = new Gson();
        em.close();
        return gson.toJson(agent);
    }

    @PUT
    @Path("/putagent")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces(MediaType.APPLICATION_JSON)
    public String putAgent(String jsonString) {
        gson = new Gson();
        agent = gson.fromJson(jsonString, Agent.class);
        // Begin transaction if Agent data is valid
        if (Validation.isValidAgent(agent)) {
            em.getTransaction().begin();
            Agent mergedAgent = em.merge(agent);
            if (mergedAgent != null) {
                em.getTransaction().commit();
                em.close();
                return "{ message: 'Update successful' }";
            } else {
                em.getTransaction().rollback();
                em.close();
                return "{ message: 'Update failed' }";
            }
        } else {
            return "{ message: 'Invalid Agent Data' }";
        }
    }

    @POST
    @Path("/postagent")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces(MediaType.APPLICATION_JSON)
    public String postAgent(String jsonString) {
        gson = new Gson();
        agent = gson.fromJson(jsonString, Agent.class);
        // Begin transaction if Agent data is valid
        if (Validation.isValidAgent(agent)) {
            em.getTransaction().begin();
            em.persist(agent);
            if (em.contains(agent)) {
                em.getTransaction().commit();
                em.close();
                return "{ message: 'Agent inserted successfully' }";
            } else {
                em.getTransaction().rollback();
                em.close();
                return "{ message: 'Agent insert failed' }";
            }
        } else {
            return "{ message: 'Invalid Agent Data' }";
        }
    }

    @DELETE
    @Path("/deleteagent/{ id }")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteAgent(@PathParam("id") int id) {
        agent = em.find(Agent.class, id);
        em.getTransaction().begin();
        em.remove(agent);
        if (em.contains(agent)) {
            em.getTransaction().rollback();
            em.close();
            return "{ message: 'Agent deletion failed' }";
        } else {
            em.getTransaction().commit();
            em.close();
            return "{ message: 'Agent deleted successful' }";
        }
    }
}