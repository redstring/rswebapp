package com.rswebapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Person entity
 * 
 * @author chuangtc
 */
@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	private String userpassword;
	
	private String firstname;
	
	private String surname;

	public Person() {
	}

	public Person(String username, String userpassword, String firstname, String surname) {
		this.setUsername(username);
		this.setUserpassword(userpassword);
		this.setFirstname(firstname);
		this.setSurname(surname);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", surname="
				+ surname + "]";
	}

}