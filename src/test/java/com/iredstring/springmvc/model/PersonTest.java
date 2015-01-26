package com.iredstring.springmvc.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Configuration;

import com.iredstring.springmvc.model.Person;

@Configuration("applicationContext.xml")
public class PersonTest {

	

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void test() {
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
		//		"applicationContext.xml");
		//PersonDaoImpl personDao = (PersonDaoImpl) context.getBean("personDao");
		//fail("Not yet implemented");

		Person peter = new Person(1234500L, 0, "Peter", "Sagan", "peter_sagan",
				"password_pe", null, 0, 0);
		Person nasta = new Person(1234501L, 0, "Nasta", "Kuzminova",
				"nasta_kuzminova", "password_na", null, 0, 0);

		/*
		 * personDao.save(peter); personDao.save(nasta);
		 * 
		 * List<Person> persons = personDao.getAll(); for (Person person :
		 * persons) { System.out.println(person); }
		 */
		assertEquals("Peter test", "Peter", peter.getFirstName());
		assertEquals("Nasta test", "Kuzminova", nasta.getLastName());

		// context.close();
	}

}
