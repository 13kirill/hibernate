package ru.netology.hibernate.repository;

import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        TypedQuery<Person> query = entityManager.createQuery("select p from Person p where p.cityOfLiving=:city_of_living", Person.class);
        query.setParameter("city_of_living", city);
        return query.getResultList();
    }
}
