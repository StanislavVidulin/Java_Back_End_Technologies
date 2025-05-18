package de.ait.tasks.controller;

/*
получить список всех задач
получить задачу по id
создать новую задачу
удалить задачу № ...
 */

import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.repository.TaskRepository;
import de.ait.tasks.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@RestController
public class TaskController {
    private final TaskService service;
    private final TaskRepository repository; // repository temporary

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponseDto> > getTasks(){
        return ResponseEntity.ok(service.getAllTasks());
    }

    // если ok то 200OK и TaskResponseDto   иначе  404NotFound
    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable("id") Long taskId){
        TaskResponseDto taskById = service.getTaskById(taskId);
        //return (taskById!=null)? ResponseEntity.ok(taskById) : ResponseEntity.notFound().build();

        return ResponseEntity.ofNullable(taskById);
      }


    @PostMapping("/tasks")
    public ResponseEntity<TaskResponseDto> createNewTask(@RequestBody TaskRequestDto task){
        TaskResponseDto savedTask = service.createTask(task);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTask.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedTask);
/*
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                //.header("location", location.toString())
                .body(savedTask);
*/

    }

    @DeleteMapping("/tasks/{id}")
    public  ResponseEntity<TaskResponseDto> deleteTaskById(@PathVariable("id") Long id){
        TaskResponseDto deletedTask = service.deleteTask(id);
        return ResponseEntity.ofNullable(deletedTask);
    }
}
