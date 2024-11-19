package org.example.tasker.services;

import org.example.tasker.domain.model.Person;

import java.util.UUID;

public interface PersonService {

    Person findPerson(Person person);
}
