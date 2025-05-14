package de.ait.homework_13.repository;

import de.ait.homework_13.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository {
    public List<Task> findAll();
    public Task findById(Long id);
    public Task save(Task task);
    public boolean deleteById(Long id);
}
