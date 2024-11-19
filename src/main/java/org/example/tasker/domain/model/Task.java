package org.example.tasker.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.tasker.domain.enums.Priority;
import org.example.tasker.domain.enums.Status;
import org.hibernate.validator.constraints.UniqueElements;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String header;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Priority priority;
    private String comment;
    @ManyToOne
    private Person author;
    @ManyToOne
    private Person assignee;
}
