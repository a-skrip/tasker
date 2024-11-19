package org.example.tasker.repositories;

import org.example.tasker.domain.model.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface TaskRepo extends JpaRepository<Task, UUID>{
    Slice<Task> findByAuthorId(UUID id, Pageable pageable);

    Slice<Task> findByAssigneeId(UUID id, Pageable pageable);

}
