package de.ait.hw2025_04_12_tasks.controller;

/*
получить список всех задач
получить задачу по id
создать новую задачу
удалить задачу № ...
 */

import de.ait.hw2025_04_12_tasks.dto.TaskResponseDto;
import de.ait.hw2025_04_12_tasks.model.Task;
import de.ait.hw2025_04_12_tasks.repository.TaskRepository;
import de.ait.hw2025_04_12_tasks.repository.TaskRepositoryMapImpl;
import de.ait.hw2025_04_12_tasks.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

//@AllArgsConstructor
@RestController
public class TaskController {

    private final TaskService service;
    private final TaskRepository repository; // repository temporary
    private final Scanner scanner;

//    //  внедрение зависимости через сеттер. Если  через сеттер, то final в поле нужно убрать
//    @Autowired
//    public void setScanner(Scanner scanner) {
//        this.scanner = scanner;
//    }

    // если убрать @Qulifier и вторую имплементацию, то можно через ломбок (@AllArgsConstructor)
    // через конструктор Spring по умолчанию добавляет @Autowired
    public TaskController(@Qualifier("taskRepositoryMapImpl") TaskRepository repository, Scanner scanner, TaskService service) {
        this.repository = repository;
        this.service = service;
        this.scanner = scanner;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
//        System.out.println("input");
//        String s = scanner.nextLine();
//        System.out.println(s);
//        return ResponseEntity.ok(service.getAllTasks());
        List<TaskResponseDto> allTasks = service.getAllTasks();
        HttpHeaders headers = new HttpHeaders(); // заголовки HTTP
        headers.add("X-Task-Size", String.valueOf(allTasks.size()));
        headers.add("X-Task-Hello", "hello from server");
        return new ResponseEntity<>(allTasks, headers, HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long taskId) {
        try {
        return ResponseEntity.ok(repository.findById(taskId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createNewTask(@RequestBody Task task) {
        System.out.println(task);
        Task saved = repository.save(task);
        try {
            return ResponseEntity.created(new URI("http://localhost:8081/tasks" + saved.getId())).body(saved);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/tasks/{id}")
    public Task deleteTaskById(@PathVariable("id") Long taskId) {
        return repository.delete(taskId);
    }
}
