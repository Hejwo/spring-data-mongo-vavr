package org.hejwo.poc.repositories;

import java.util.Collection;

import org.assertj.core.util.Lists;
import org.hejwo.poc.SpringDataMongoVavrApplication;
import org.hejwo.poc.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.vavr.collection.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
    classes = {
        SpringDataMongoVavrApplication.class,
        EmbeddedMongoAutoConfiguration.class
    }
)
public class PersonRepositoryIntegrationTest {

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void setUp() {
        personRepository.deleteAll();
    }

    @Test
    public void shouldInsertPerson() {
        Person person1 = Person.builder()
            .name("John")
            .nickname("crazy123")
            .age(21).build();

        personRepository.save(person1);

        Collection<Person> personRepositoryAll = personRepository.findAll();
        assertThat(personRepositoryAll).hasSize(1);
    }

    @Test
    public void shouldFindByAge() {
        insertTwoPersons(21);

        List<Person> byAge = personRepository.findByAge(21);

        assertThat(byAge).hasSize(2);
    }

    private void insertTwoPersons(Integer age) {
        Person person1 = Person.builder()
            .name("John")
            .nickname("crazy123")
            .age(age).build();

        Person person2 = Person.builder()
            .name("Adam")
            .nickname("notCrazy123")
            .age(age).build();

        personRepository.save(Lists.newArrayList(person1, person2));
    }
}