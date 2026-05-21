package com.redhat.training.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.annotation.Resource;
import jakarta.ejb.EJBException;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.UserTransaction;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

import com.redhat.training.model.Person;

@Stateless
@Path("persons")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@TransactionManagement(TransactionManagementType.BEAN)
public class PersonService {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    UserTransaction tx;

    // Simple non-RESTy method for JSF bean invocation
    public String hello(String name) {
        
        try {
            
            try {
                
                // start a new transaction
                tx.begin();

                // let's grab the current date and time on the server
                LocalDateTime today = LocalDateTime.now();

                // format it nicely for on-screen display
                DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm:ss a");
                String fdate = today.format(format);

                // Create a new Person object and persist to database
                Person p = new Person();
                p.setName(name);
                entityManager.persist(p);

                // respond back with Hello and convert the name to UPPERCASE. Also, send the
                // current time on the server.
                return "Hello " + name.toUpperCase() + "!. " + "Time on the server is: " + fdate;
            } finally {
                // commit the transaction
                tx.commit();
            }
        } catch (Exception e) {
            
            throw new EJBException(e);
        }
    }

    // CRUD RESTful methods below
    // fetch result by Person id
    public Person getPerson(@PathParam("id") Long id) {
        
        return entityManager.find(Person.class, id);
    }

    // Dump all Person objects in the Database
    @GET
    public List<Person> getAllPersons() {
        
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> persons = query.getResultList();

        return persons;
    }

    // delete an object by Person id
    @DELETE
    @Path("{id}")
    public void deletePerson(@PathParam("id") Long id) {
        
        try {
            
            try {
                
                tx.begin();
                entityManager.remove(getPerson(id));
            } finally {
                
                tx.commit();
            }
        } catch (Exception e) {
            
            throw new EJBException();
        }
    }

    // Save a Person object to Database
    @POST
    public Response savePerson(Person person) {
        
        try {
            
            try {
                
                ResponseBuilder builder;
                
                if (person.getId() == null) {
                    
                    Person newPerson = new Person();
                    newPerson.setName(person.getName());
                    tx.begin();
                    entityManager.persist(newPerson);
                    builder = Response.ok();
                } else {
                    
                    Person uPerson;
                    Person updatePerson = getPerson(person.getId());
                    updatePerson.setName(person.getName());
                    uPerson = entityManager.merge(updatePerson);
                    builder = Response.ok(uPerson);
                }

                return builder.build();
            } finally {
                
                tx.commit();
            }
        } catch (Exception e) {
            
            throw new EJBException(e);
        }
    }
}
