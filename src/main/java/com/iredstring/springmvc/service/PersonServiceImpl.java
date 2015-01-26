package com.iredstring.springmvc.service;

import java.io.IOException;
import java.util.List;

import com.iredstring.springmvc.dao.PersonDao;
import com.iredstring.springmvc.model.Employee;
import com.iredstring.springmvc.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService{

	
	@Autowired
	private PersonDao dao;
	

	@Override
	public Person getPersonByUsername(String username) {
		return dao.getPersonByUsername(username);
		
	}

	@Override
	public String getPersonJsonByUsername(String username) {
		Person person = dao.getPersonByUsername(username);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		String str1 = "";
		try {
			// mapper.writeValue(System.out, p1);
			str1 = mapper.writeValueAsString(person);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str1;
	}

	public List<Person> findAllPeople() {
		return dao.findAllPeople();
	}

	public void deletePersonByUsername(String username) {
		dao.deletePersonByUsername(username);		
	}

	
}

