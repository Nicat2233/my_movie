package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person update(Long id, Person person) {
        Person existing = personRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setName(person.getName());
        existing.setAge(person.getAge());
        return personRepository.save(existing);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}
