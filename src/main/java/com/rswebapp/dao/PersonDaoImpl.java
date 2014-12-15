package com.rswebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
 
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;
 


import com.rswebapp.model.Person;
 
/**
 * DAO implementation for Person entity
 *  
 * @author chuangtc
 */
@Transactional
public class PersonDaoImpl {
 
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Read one by user 
     * */
    public Person getPersonById(Long id) {   	 
        try {
            String qlString = "SELECT p FROM Person p WHERE p.id = ?1";
            TypedQuery<Person> query = em.createQuery(qlString, Person.class);        
            query.setParameter(1, id);
     
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    /**
     * Read one by username 
     * */
    public Person getPersonByUsername(String username) {   	 
        try {
            String qlString = "SELECT p FROM Person p WHERE p.username = ?1";
            TypedQuery<Person> query = em.createQuery(qlString, Person.class);        
            query.setParameter(1, username);
     
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    /**
     * Read all 
     * */
    public List<Person>getAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }
    
    /**
     * Create one in database
     * */
    public Long save(Person person) {
        em.persist(person);
        return person.getId();
    }

    /**
     * Update one in database
     * */ 
    public Long update(Person person){
    	em.merge(person);
    	return person.getId();
    }
    
    /**
     * Delete one in database
     * */
    public Long delete(Person person) {
        em.remove(person);
        return 1L;
    }
    

}