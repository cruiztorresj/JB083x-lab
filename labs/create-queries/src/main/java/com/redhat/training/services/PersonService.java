package com.redhat.training.services;

import com.redhat.training.model.Person;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class PersonService {

    @PersistenceContext(unitName="helloPU")
	private EntityManager entityManager;

	// Get all Person objects in the Database
    public List<Person> getAllPersons() {

        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p", Person.class);

        return query.getResultList();
    }

    //Get persons whose name matches the name given in the query
    public List<Person> getPersonsWithName(String name) {

        TypedQuery<Person> query = entityManager.createNamedQuery("getAllPersonsWithName", Person.class);

        query.setParameter("pname", name);

        return query.getResultList();
    }
}
