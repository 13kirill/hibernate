package ru.netology.hibernate.service;

import org.springframework.stereotype.Service;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonByCity (String city){
        List<Person> personList = personRepository.getPersonsByCity(city);
        return personList;
    }
}
