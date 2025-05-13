package de.ait.hw2025_04_12_tasks.controller;

/*
получить список всех задач
получить задачу по id
создать новую задачу
удалить задачу № ...
 */

import de.ait.hw2025_04_12_tasks.model.Task;
import de.ait.hw2025_04_12_tasks.repository.TaskRepository;
import de.ait.hw2025_04_12_tasks.repository.TaskRepositoryMapImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

//@AllArgsConstructor
@RestController
public class TaskController {

    private final TaskRepository repository;
    private final Scanner scanner;

//    //  внедрение зависимости через сеттер. Если  через сеттер, то final в поле нужно убрать
//    @Autowired
//    public void setScanner(Scanner scanner) {
//        this.scanner = scanner;
//    }

    // если убрать @Qulifier и вторую имплементацию, то можно через ломбок (@AllArgsConstructor)
    // через конструктор Spring по умолчанию добавляет @Autowired
    public TaskController(@Qualifier("taskRepositoryMapImpl") TaskRepository repository, Scanner scanner) {
        this.repository = repository;
        this.scanner = scanner;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        System.out.println("input");
        String s = scanner.nextLine();
        System.out.println(s);
        return repository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable("id") Long taskId) {
        return repository.findById(taskId);
    }

    @PostMapping("/tasks")
    public Task createNewTask(@RequestBody Task task) {
        System.out.println(task);
        return repository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public Task deleteTaskById(@PathVariable("id") Long taskId) {
        return repository.delete(taskId);
    }
}
