package de.ait.homework_16.controller;

import de.ait.homework_16.dto.TaskDto;
import de.ait.homework_16.exceptions.TaskNotFoundException;
import de.ait.homework_16.repository.TaskRepository;
import de.ait.homework_16.service.TaskService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

//@AllArgsConstructor
@RestController
public class TaskController {
    private final TaskService service;

    private final TaskRepository repository;
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
    public ResponseEntity<List<TaskDto>> getTasks() {
        List<TaskDto> allTasks = service.getAllTasks();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long taskId) {
        try {
            return ResponseEntity.ok(service.getTaskById(taskId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskDto> createNewTask(@RequestBody TaskDto dto) {
        TaskDto savedDto = service.addTask(dto);
        try {
            return ResponseEntity.created(new URI("http://localhost:8081/tasks")).body(savedDto);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable("id") Long taskId) {
        try {
            service.deleteTaskById(taskId);
            return ResponseEntity.noContent().build();
        } catch (TaskNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
