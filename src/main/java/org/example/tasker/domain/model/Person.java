package org.example.tasker.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.example.tasker.domain.enums.Privilege;
import org.example.tasker.domain.enums.Role;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
public class Person implements Serializable{

    @Id
    private UUID id;
    private String email;
    private String password;
    private Role role;
    private Privilege privilege;

}
