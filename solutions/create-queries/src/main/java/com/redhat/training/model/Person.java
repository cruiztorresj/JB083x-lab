package com.redhat.training.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
//add named query here
@NamedQuery(
		name="getAllPersonsWithName",
		query="select p from Person p where p.name = :pname")
public class Person {

    @Id
    private Long id;

    private String name;

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
		} if (obj == null) {

			return false;
		} else if (obj.getClass() != getClass()) {

			return false;
        } else {

            Person other = (Person) obj;
		    if (id == null) {

			    if (other.id != null) {

				    return false;
                }
		    } else if (!id.equals(other.id)) {

                return false;
            }
        }

		return true;
	}    
}
