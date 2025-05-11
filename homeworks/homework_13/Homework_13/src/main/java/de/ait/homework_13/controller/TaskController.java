package de.ait.homework_13.controller;

import de.ait.homework_13.model.Task;
import de.ait.homework_13.repository.TaskDB;
import de.ait.homework_13.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    TaskRepository repository = new TaskDB();

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable(name = "id") Long taskId) {
        return repository.findById(taskId);
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        return repository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public boolean deleteTask(@PathVariable(name = "id") Long taskId) {
        return repository.deleteById(taskId);
    }
}
