package com.gsrao.mongodb.controller;

import com.gsrao.mongodb.model.Person;
import com.gsrao.mongodb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * PersonController handles HTTP requests related to Person operations.
 * It provides endpoints for creating, retrieving, updating, and deleting Person records.
 */
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PostMapping ("/create")
    public Person createPersonInMongoDb(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable String id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
    }

    @GetMapping
    public Iterable<Person> getAllPersons() {
        return personService.getAllPersons();
    }
}