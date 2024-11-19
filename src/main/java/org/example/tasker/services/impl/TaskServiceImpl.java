package org.example.tasker.services.impl;

import lombok.Data;
import org.example.tasker.domain.model.Task;
import org.example.tasker.exception.TaskNotFoundException;
import org.example.tasker.repositories.TaskRepo;
import org.example.tasker.services.TaskService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Data
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    @Override
    public UUID save(Task task) {
        return taskRepo.save(task).getId();
    }

    @Override
    public Task findTaskById(UUID id) {
        return null;
    }

    @Override
    public Slice<Task> findAllSlice(Pageable pageable) {
        return taskRepo.findAll(pageable);
    }

    public void editTask(Task task) {
        taskRepo.findById(task.getId()).orElseThrow(() -> new TaskNotFoundException(String.format("Task with id: %s not found", task.getId())));
        taskRepo.save(task);
    }

    // Обработать ошибку с возвратом в теле запроса!!!
    @Override
    public void deleteTaskById(UUID id) {
        Optional<Task> task = taskRepo.findById(id);
        if (task.isEmpty()) {
            throw new TaskNotFoundException("Task not found");
        }
        taskRepo.deleteById(task.get().getId());
    }

    @Override
    public Slice<Task> findByAuthorId(UUID id, Pageable pageable) {
        return taskRepo.findByAuthorId(id, pageable);
    }

    @Override
    public Slice<Task> findByAssigneeId(UUID id, Pageable pageable) {
        return taskRepo.findByAssigneeId(id, pageable);

    }

}
