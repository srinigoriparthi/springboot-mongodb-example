package com.gsrao.mongodb.repository;

import com.gsrao.mongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}