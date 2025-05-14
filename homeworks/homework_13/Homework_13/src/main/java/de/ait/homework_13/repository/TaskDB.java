package de.ait.homework_13.repository;

import de.ait.homework_13.exceptions.TaskNotFoundException;
import de.ait.homework_13.model.Task;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class TaskDB implements TaskRepository {
    private static HashMap<Long, Task> tasks = new HashMap<>();
    static {
        tasks.put(1L, new Task(1L, "Task1", "High"));
        tasks.put(2L, new Task(2L, "Task2", "Low"));
        tasks.put(3L, new Task(3L, "Task3", "High"));
        tasks.put(4L, new Task(4L, "Task4", "Low"));
        tasks.put(5L, new Task(5L, "Task5", "Medium"));
        tasks.put(6L, new Task(6L, "Task6", "Low"));
    }

    @Override
    public List<Task> findAll() {
        return tasks.values().stream().toList();
    }

    @Override
    public Task findById(Long id) {
        Task task = tasks.get(id);
        if (task == null) {
            throw new TaskNotFoundException();
        }
        return task;
    }

    @Override
    public Task save(Task task) {
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public boolean deleteById(Long id) {
        return tasks.remove(id) != null;
    }
}
