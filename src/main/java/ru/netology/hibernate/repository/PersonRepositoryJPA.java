package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.netology.hibernate.entity.Identifier;
import ru.netology.hibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public interface PersonRepositoryJPA extends JpaRepository<Person, Identifier> {

    List<Person> findByCityOfLiving(String city);

    List<Person> findAllByIdentifierAgeLessThanOrderByIdentifierAgeAsc(int age);

    Optional<Person> findAllByIdentifierNameAndIdentifierSurname(String name, String surname);
}
