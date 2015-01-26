package com.iredstring.springmvc.service;

import java.util.List;

import com.iredstring.springmvc.model.Person;

public interface PersonService {

	Person getPersonByUsername(String username);
	String getPersonJsonByUsername(String username);
	List<Person> findAllPeople();
	void deletePersonByUsername(String username);
	
}
