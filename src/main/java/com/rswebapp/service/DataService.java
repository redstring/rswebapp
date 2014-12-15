package com.rswebapp.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rswebapp.dao.PersonDaoImpl;
import com.rswebapp.model.Person;

@Service
public class DataService {

	@Autowired
	PersonDaoImpl personDao;

	public Person getPersonByUserid(Long id){
		return personDao.getPersonById(id);
	}
	
	@Transactional
	public Person getPersonByUsername(String username) {
		Person person = personDao.getPersonByUsername(username);
		return person;
	}
	
	@Transactional
	public String getPersonJsonByUsername(String username) {
		return getPersonJson(getPersonByUsername(username));
	}
	
	@Transactional
	public String getPersonJson(Person person) {
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

}