package org.example.tasker.controller;

import lombok.RequiredArgsConstructor;
import org.example.tasker.domain.model.Task;
import org.example.tasker.services.impl.TaskServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskServiceImpl taskServiceImpl;

    @GetMapping("/")
    public Slice<Task> getTasks(@RequestParam int page, @RequestParam int size) {
        return taskServiceImpl.findAllSlice(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable UUID id) {
        return taskServiceImpl.findTaskById(id);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addTask(@RequestBody Task task) {

        return ResponseEntity.status(201).body(taskServiceImpl.save(task));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable UUID id) {
        taskServiceImpl.deleteTaskById(id);
    }

    //Если не перелаю ID то создается новый
    @PutMapping(value = "/write")
    public void writeTask(@RequestBody Task task) {
        taskServiceImpl.editTask(task);
    }

}
