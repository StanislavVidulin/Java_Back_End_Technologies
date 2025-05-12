package de.ait.hw2025_04_12_tasks.controller;

import de.ait.hw2025_04_12_tasks.model.Programmer;
import de.ait.hw2025_04_12_tasks.model.Task;
import de.ait.hw2025_04_12_tasks.repository.ProgrammerRepository;
import de.ait.hw2025_04_12_tasks.repository.ProgrammerRepositoryMapImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProgrammerController {

    private final ProgrammerRepository repository;

    @GetMapping("/programmers")
    public List<Programmer> getProgrammers() {
        return repository.findAll();
    }

    @GetMapping("/programmers/{id}")
    public Programmer getProgrammerById(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    // получить список задач заданного программиста (GET programmers/id/tasks)
    @GetMapping("/programmers/{id}/tasks")
    public List<Task> getTaskByProgrammer(@PathVariable("id") Long id) {
        return repository.findTasksByProgrammerId(id);
    }

    //поручить программисту задачу (PUT programmers/programmerId/tasks/taskId)
    @PutMapping("/programmers/{programmerId}/tasks/{taskId}")
    public void addTaskToProgrammer(@PathVariable("programmerId") Long programmerId, @PathVariable("taskId") Long taskId) {
        repository.addTaskToProgrammer(programmerId, taskId);
    }

    @PostMapping("/programmer")
    public Programmer addProgrammer(@RequestBody Programmer programmer) {
        return repository.save(programmer);
    }

    @DeleteMapping("/programmers/{idProgrammer}/tasks/{idTask}")
    public void deleteProgrammer(@PathVariable Long idProgrammer, @PathVariable Long idTask) {
        repository.deleteTaskToProgrammer(idProgrammer, idTask);
    }
}
