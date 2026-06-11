package com.redhat.training.ejb;

import java.util.HashSet;
import java.util.Set;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import com.redhat.training.model.PersonaGroup;

@Stateless
public class PersonaBean {

	@Inject
	private EntityManager em;

	public Set<PersonaGroup> getAllPersonaGroups(){

		TypedQuery<PersonaGroup> query = em.createQuery("SELECT g FROM PersonaGroup g JOIN FETCH g.personas" , PersonaGroup.class);

        return new HashSet<PersonaGroup>(query.getResultList());
	}
}
