package de.ait.hw2025_04_12_tasks.repository;

import de.ait.hw2025_04_12_tasks.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryListImpl implements TaskRepository {
    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public Task findById(Long id) {
        return null;
    }

    @Override
    public Task delete(Long id) {
        return null;
    }

    @Override
    public Task save(Task task) {
        return null;
    }
}
