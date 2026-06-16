package com.redhat.training.ui;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import com.redhat.training.ejb.PersonaBean;
import com.redhat.training.model.Persona;
import com.redhat.training.model.PersonaGroup;

@Named("groupView")
@Stateless
public class GroupViewBean {

	private Set<PersonaGroup> groups;

	private PersonaGroup currentGroup;

	private Set<Persona> personas;

	@Inject
	private Logger log;

	@Inject
	PersonaBean peopleBean;

	@PostConstruct
	public void init() {

		log.info("INIT!!!");
		groups = peopleBean.getAllPersonaGroups();

	}

	public void update(ValueChangeEvent event) {

		PersonaGroup group = (PersonaGroup) event.getNewValue();
		personas = new HashSet<Persona>(group.getPersonas());
			
	}

	public Set<PersonaGroup> getGroups() {

		return groups;
	}

	public void setGroups(Set<PersonaGroup> personaGroups) {

		this.groups = personaGroups;
	}

	public Set<Persona> getPersonas() {

		return personas;
	}

	public void setPersonas(Set<Persona> personas) {

		this.personas = personas;
	}

	public PersonaGroup getCurrentGroup() {

		return currentGroup;
	}

	public void setCurrentGroup(PersonaGroup currentGroup) {

		this.currentGroup = currentGroup;
	}

	public List<Persona> getPersonaList() {

		if(personas != null) {

			return new ArrayList<Persona>(personas);
		} else {

			return new ArrayList<Persona>();
		}
	}
}
