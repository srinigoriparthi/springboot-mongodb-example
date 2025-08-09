package com.gsrao.mongodb.service;

import com.gsrao.mongodb.model.Person;
import com.gsrao.mongodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPersonById(String id) {
        return personRepository.findById(id).orElse(null);
    }

    public void deletePerson(String id) {
        personRepository.deleteById(id);
    }

    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }
}