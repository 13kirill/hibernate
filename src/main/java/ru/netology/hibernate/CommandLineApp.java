package ru.netology.hibernate;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.hibernate.entity.Identifier;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.PersonRepositoryJPA;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class CommandLineApp implements CommandLineRunner {

    private final PersonRepositoryJPA personRepositoryJPA;

//    @PersistenceContext
//    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) {

        var names = List.of("Вася", "Петя", "Саша", "Федя");
        var surnames = List.of("Васильев", "Петров", "Александров", "Федоров");
        var cities = List.of("Москва", "Казань", "Пермь", "Иваново");
        var phoneNumbers = List.of("899912341212", "899912341313", "899912341414", "899912341414");

        var random = new Random();
        IntStream.range(0, 100)
                .forEach(i -> {
                    Person person = Person.builder()
                            .identifier(Identifier.builder()
                                    .name(names.get(random.nextInt(names.size())) + i)
                                    .surname(surnames.get(random.nextInt(surnames.size())) + i)
                                    .age(random.nextInt(0,100) + i)
                                    .build())
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .phoneNumber(phoneNumbers.get(random.nextInt(phoneNumbers.size())))
                            .build();

                    personRepositoryJPA.save(person);
                    personRepositoryJPA.findByCityOfLiving("Москва")
                            .forEach(System.out::println);
//                    personRepositoryJPA.findAllByIdentifierAgeLessThanOrderByIdentifierAgeAsc(5)
//                            .forEach(System.out::println);
                });

//        Query query = entityManager.createQuery("select p from Person p where p.cityOfLiving=:city_of_living");
//query.setParameter("city_of_living", "Москва");
//query.getResultList().forEach(System.out::println);

    }
}