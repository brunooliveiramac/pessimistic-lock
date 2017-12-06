package com.sensey.lock.repository;

import com.sensey.lock.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findByDescription(String description);

}
