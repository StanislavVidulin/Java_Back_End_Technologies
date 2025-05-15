package de.ait.homework_15.controller;

/*
получить список всех задач
получить задачу по id
создать новую задачу
удалить задачу № ...
 */

import de.ait.homework_15.dto.TaskDto;
import de.ait.homework_15.model.Task;
import de.ait.homework_15.repository.TaskRepository;
import de.ait.homework_15.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
    public List<TaskDto> getTasks() {
//        System.out.println("input");
//        String s = scanner.nextLine();
//        System.out.println(s);
        return service.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public TaskDto getTaskById(@PathVariable("id") Long taskId) {
        return service.getTaskById(taskId);
    }

    @PostMapping("/tasks")
    public TaskDto createNewTask(@RequestBody TaskDto dto) {
        return service.addTask(dto);
    }

    @DeleteMapping("/tasks/{id}")
    public boolean deleteTaskById(@PathVariable("id") Long taskId) {
        return service.deleteTaskById(taskId);
    }
}
