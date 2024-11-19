package org.example.tasker.domain.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.tasker.domain.enums.Priority;
import org.example.tasker.domain.enums.Status;
import org.example.tasker.domain.model.Person;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class TaskDto {


    @NotEmpty(message = "title cannot be null or empty!")
//    @JsonProperty("header")
    private String header;
//    @JsonProperty("description")
    private String description;
//    @JsonProperty("status")
    private Status status;
//    @JsonProperty("priority")
    private Priority priority;
//    @JsonProperty("comment")
    private String comment;
//    @JsonProperty("author")
    private Person author;
//    @JsonProperty("assignee")
    private Person assignee;
}
