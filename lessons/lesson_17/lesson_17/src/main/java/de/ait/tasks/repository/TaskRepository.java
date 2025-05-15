package de.ait.tasks.repository;

import de.ait.tasks.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    Task findById(Long id);
    Task delete(Long id);
    Task save(Task task);


}
