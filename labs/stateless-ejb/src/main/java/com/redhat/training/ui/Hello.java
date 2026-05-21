package com.redhat.training.ui;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import com.redhat.training.ejb.HelloBean;

@RequestScoped
@Named("hello")
public class Hello {

	private String name;
	
	@EJB
	HelloBean helloEJB;

	public String greet() {
		
        return helloEJB.sayHello(name);
	}
	public void sayHello() {
		
        String response = greet();
		FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage(response));
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}
}
