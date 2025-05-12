package de.ait.hw2025_04_12_tasks.repository;

import de.ait.hw2025_04_12_tasks.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    Task findById(Long id);
    Task delete(Long id);
    Task save(Task task);
}
