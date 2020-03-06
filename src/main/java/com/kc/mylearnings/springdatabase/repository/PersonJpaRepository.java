package com.kc.mylearnings.springdatabase.repository;

import com.kc.mylearnings.springdatabase.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    //Connect to DB
    // EntityManager is the interface for PersistenceContext
    @PersistenceContext
    EntityManager entityManager;

    public Person findByID(int id){
        return  entityManager.find(Person.class, id);
    }

    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        Person person = this.findByID(id);
        entityManager.remove(person);
    }

    public List<Person> findAll(){
        //Create a named query and define that on Person Entity
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }
    //HQL (Hibernate Query Language)
    //JPQA (Java Persistent Query Language)
    //Named query
}
