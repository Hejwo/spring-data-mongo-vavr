package org.hejwo.poc.repositories;

import org.hejwo.poc.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import io.vavr.collection.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByAge(Integer age);

}
