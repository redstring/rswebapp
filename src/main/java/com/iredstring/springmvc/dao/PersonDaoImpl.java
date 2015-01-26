package com.iredstring.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.iredstring.springmvc.model.Person;

@Repository("personDao")
public class PersonDaoImpl extends AbstractDao implements PersonDao{

	public void savePerson(Person person) {
		persist(person);		
	}

	public Person getPersonByUsername( String username){
		Query query = getSession().createQuery("FROM PERSON p WHERE p.username = "+username );
		List<Person> results = query.list();
		if (results.size()==0)
			return null;
		return results.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> findAllPeople() {
		Criteria criteria = getSession().createCriteria(Person.class);
		return (List<Person>) criteria.list();
	}

	public void deletePersonByIrsid(Long irsid) {
		Query query = getSession().createSQLQuery("delete from PERSON where irsid = :irsid");
		query.setParameter("irsid", irsid);
		query.executeUpdate();
		
	}

	@Override
	public void deletePersonByUsername(String username) {
		Query query = getSession().createSQLQuery("delete from PERSON where username = :username");
		query.setParameter("username", username);
		query.executeUpdate();
		
	}

}
