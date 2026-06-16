package com.redhat.training.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String address;
	
	@OneToOne(mappedBy="email")
	private Persona persona;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public Persona getPersona() {

		return persona;
	}

	public void setPersona(Persona persona) {

		this.persona = persona;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}
	
	@Override
	public String toString() {

		return "Email [id=" + id + "]";
	}
	
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == this) {

			return true;
		} else if (obj == null) {

			return false;
		} else if (getClass() != obj.getClass()) {

			return false;
        } else {

		    Email other = (Email) obj;
		    if (id == null) {

			    if (other.id != null) {

				    return false;
		        } else if (!id.equals(other.id)) {

                    return false;
                }
            }
        }

		return true;
	}	
}
