package com.iredstring.springmvc;

import java.io.IOException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.iredstring.springmvc.model.Person;
import com.iredstring.springmvc.dao.PersonDaoImpl;

public class TestPerson {

	private static final String applicationContext="applicationContext.xml";
	public static void main(String[] args) {

		loadDBMemory();
		saveDBtoFile();
		
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
		
		List<Person> persons = dao.findAllPeople();
		for (Person person : persons) {
			// System.out.println(person);
		}
		context.close();
		return persons;
	}

	public static void saveDBtoFile() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(applicationContext);
		PersonDaoImpl dao = (PersonDaoImpl) context.getBean("personDao");

		
		Person peter = new Person(1234500L, 0, "Peter", "Sagan","peter_sagan", "password_pe",
				null, 0, 0);
		Person nasta = new Person(1234501L, 0, "Nasta", "Kuzminova","nasta_kuzminova", "password_na",
				null, 0, 0);

		dao.savePerson(peter);
		dao.savePerson(nasta);

		context.close();

	}

	public static void loadDBMemory() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(applicationContext);
		PersonDaoImpl dao = (PersonDaoImpl) context.getBean("personDao");

		Person peter = new Person(1234500L, 0, "Peter", "Sagan","peter_sagan", "password_pe",
				null, 0, 0);
		Person nasta = new Person(1234501L, 0, "Nasta", "Kuzminova","nasta_kuzminova", "password_na",
				null, 0, 0);

		dao.savePerson(peter);
		dao.savePerson(nasta);

		Person tmp=dao.getPersonByUsername("peter_sagan");
		System.out.println(tmp);
		
		List<Person> persons = dao.findAllPeople();
		for (Person person : persons) {
			System.out.println(person);
		}
		context.close();
		System.out.println("Finished loading to memory db.");

	}

}
