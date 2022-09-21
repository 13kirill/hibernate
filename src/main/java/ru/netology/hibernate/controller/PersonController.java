package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonByCity(@RequestParam("city") String city) {
        return personService.getPersonByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonByAge(@RequestParam("age") int age) {
        return personService.getPersonByAge(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam("name") String name,
                                                      @RequestParam("surname") String surname) {
        return personService.getPersonByNameAndSurname(name, surname);
    }
}
