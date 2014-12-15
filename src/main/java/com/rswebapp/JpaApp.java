package com.rswebapp;

import java.io.IOException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rswebapp.dao.PersonDaoImpl;
import com.rswebapp.model.Person;

public class JpaApp {

	private static final String applicationContext="applicationContext.xml";
	public static void main(String[] args) {

		 //loadDBMemory();
		//saveDBtoFile();
		
		List<Person> persons = readDBfromFile();
		System.out.println(persons.get(0));

		Person p1 = persons.get(0);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		try {
			//mapper.writeValue(System.out, p1);
			String str1 = mapper.writeValueAsString(p1);
			System.out.println(str1);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static List<Person> readDBfromFile() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(applicationContext);
		PersonDaoImpl dao = (PersonDaoImpl) context.getBean("personDao");
		
		//Person p1 = dao.getPersonByUsername("peter");
		//System.out.println(p1);
		
		List<Person> persons = dao.getAll();
		for (Person person : persons) {
			// System.out.println(person);
		}
		context.close();
		return persons;
	}

	public static void saveDBtoFile() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(applicationContext);
		PersonDaoImpl dao = (PersonDaoImpl) context.getBean("personDao");

		Person peter = new Person("peter", "password_pe", "Peter", "Sagan");
		Person nasta = new Person("nasta", "password_na", "Nasta", "Kuzminova");

		dao.save(peter);
		dao.save(nasta);

		context.close();

	}

	public static void loadDBMemory() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(applicationContext);
		PersonDaoImpl dao = (PersonDaoImpl) context.getBean("personDao");

		Person peter = new Person("peter", "password_pe", "Peter", "Sagan");
		Person nasta = new Person("nasta", "password_na", "Nasta", "Kuzminova");

		dao.save(peter);
		dao.save(nasta);

		List<Person> persons = dao.getAll();
		for (Person person : persons) {
			System.out.println(person);
		}
		context.close();

	}

}
