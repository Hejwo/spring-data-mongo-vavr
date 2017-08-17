package org.hejwo.poc.controller;

import org.hejwo.poc.domain.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.vavr.collection.List;

@RestController
public class MainController {

    @RequestMapping(method = RequestMethod.GET, path = "/sample-persons")
    public ResponseEntity<List<Person>> getSamplePersons() {
        Person person1 = Person.builder()
            .name("Donald").nickname("Trump").age(61)
            .build();

        Person person2 = Person.builder()
            .name("George").nickname("Bush").age(65)
            .build();

        return ResponseEntity.ok(List.of(person1, person2));
    }

}
