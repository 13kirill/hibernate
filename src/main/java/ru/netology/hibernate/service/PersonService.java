package ru.netology.hibernate.service;

import org.springframework.stereotype.Service;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.PersonRepository;
import ru.netology.hibernate.repository.PersonRepositoryJPA;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    PersonRepositoryJPA personRepositoryJPA;

    public PersonService(PersonRepositoryJPA personRepositoryJPA) {
        this.personRepositoryJPA = personRepositoryJPA;
    }

    public List<Person> getPersonByCity (String city) {
        return personRepositoryJPA.findByCityOfLiving(city);
    }

    public List<Person> getPersonByAge (int age){
        return personRepositoryJPA.findAllByIdentifierAgeLessThanOrderByIdentifierAgeAsc(age);
    }
    public Optional<Person> getPersonByNameAndSurname (String name, String surname){
        return personRepositoryJPA
                .findAllByIdentifierNameAndIdentifierSurname(name, surname);
    }
}
