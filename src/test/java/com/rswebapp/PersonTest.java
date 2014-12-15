package com.rswebapp;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rswebapp.dao.PersonDaoImpl;
import com.rswebapp.model.Person;

@Configuration("applicationContext.xml")
public class PersonTest {
	
	@Autowired
	PersonDaoImpl personDao;
	
	@Before
	public void setUp() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonDaoImpl personDao = (PersonDaoImpl) context.getBean("personDao");
		//fail("Not yet implemented");
		Person peter = new Person("peter", "password_pe","Peter","Sagan");
		Person nasta = new Person("nasta", "password_na","Nasta","Kuzminova");

		/*
		personDao.save(peter);
		personDao.save(nasta);
		
		List<Person> persons = personDao.getAll();
		for (Person person : persons) {
			System.out.println(person);
		}
		*/
		assertEquals("Peter test", "peter", peter.getUsername());
		assertEquals("Nasta test", "Kuzminova", nasta.getSurname());
		
		//context.close();
	}

}
