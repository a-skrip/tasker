package org.example.tasker.services.impl;

import lombok.Data;
import org.example.tasker.domain.model.Person;
import org.example.tasker.repositories.PersonRepo;
import org.example.tasker.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Data
public class PersonServiceImpl implements PersonService {

    private final PersonRepo personRepo;

    @Override
    public Person findPerson(Person person) {
        return personRepo.findById(person.getId()).orElseThrow();
    }
    public Person createPerson(Person person) {
        return personRepo.save(person);
    }
}
