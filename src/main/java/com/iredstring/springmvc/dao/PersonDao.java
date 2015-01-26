package com.iredstring.springmvc.dao;

import java.util.List;



import com.iredstring.springmvc.model.Person;

public interface PersonDao {
	
	void savePerson(Person person);
	
	Person getPersonByUsername( String username);
	
	List<Person> findAllPeople();
	
	void deletePersonByIrsid(Long irsid);

	void deletePersonByUsername(String username);
}
