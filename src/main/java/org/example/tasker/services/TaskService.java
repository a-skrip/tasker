package org.example.tasker.services;

import org.example.tasker.domain.model.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface TaskService {

    UUID save(Task task) throws Exception;

    Task findTaskById(UUID id);

    Slice<Task> findAllSlice(Pageable pageable);

    void deleteTaskById(UUID id) throws Exception;

    Slice<Task> findByAuthorId(UUID id, Pageable pageable);

    Slice<Task> findByAssigneeId(UUID id, Pageable pageable);
}
