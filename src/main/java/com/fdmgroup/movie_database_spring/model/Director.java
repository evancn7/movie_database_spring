package com.fdmgroup.movie_database_spring.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "director_gen")
	@SequenceGenerator(name = "director_gen", sequenceName = "director_SEQ", allocationSize = 1)
	private long directorId;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	private int age;

	@Column
	private String email;

	public Director() {
		super();
	}

	public Director(String firstname, String lastname, int age, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
	}

	public long getDirectorId() {
		return directorId;
	}

	public void setDirectorId(long directorId) {
		this.directorId = directorId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, email, firstname, lastname, directorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Director other = (Director) obj;
		return age == other.age && Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname) && directorId == other.directorId;
	}

	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", firstname=" + firstname + ", lastname=" + lastname + ", age="
				+ age + ", email=" + email + "]";
	}

}
