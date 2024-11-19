package org.example.tasker.repositories;

import org.example.tasker.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepo extends JpaRepository<Person, UUID> {
}
