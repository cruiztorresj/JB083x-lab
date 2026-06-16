package com.redhat.training.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

    @OneToOne
    @JoinColumn(name="emailID")
	private Email email;

    @ManyToOne
    @JoinColumn(name="groupId")
    private PersonaGroup personaGroup;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public PersonaGroup getDepartment() {

		return personaGroup;
	}

	public void setDepartment(PersonaGroup personaGroup) {

		this.personaGroup = personaGroup;
	}

	public Email getEmail() {

		return email;
	}

	public void setEmail(Email email) {

		this.email = email;
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
		} if (obj.getClass() != getClass()) {

			return false;
        } else {

            Persona other = (Persona) obj;
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

	@Override
	public String toString() {

        return "Persona [id=" + id + ", name=" + name + ", group=" + personaGroup + ", email=" + email + "]";
	}
}
