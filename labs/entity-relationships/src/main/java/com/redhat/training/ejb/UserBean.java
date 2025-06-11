package com.redhat.training.ejb;


import java.util.HashSet;
import java.util.Set;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import com.redhat.training.model.UserGroup;

@Stateless
public class UserBean {

	@Inject
	private EntityManager em;

	//TODO Add JOIN FETCH 
	public Set<UserGroup> getAllUserGroups(){
		TypedQuery<UserGroup> query = em.createQuery("SELECT g FROM UserGroup g" , UserGroup.class);

        return new HashSet<UserGroup>(query.getResultList());
	}


}
