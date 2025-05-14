package de.ait.homework_13.controller;

import de.ait.homework_13.model.Programmer;
import de.ait.homework_13.model.Task;
import de.ait.homework_13.repository.ProgrammerDB;
import de.ait.homework_13.repository.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgrammerController {
    private final ProgrammerRepository repository;

    @Autowired
    public ProgrammerController(ProgrammerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/programmers")
    public List<Programmer> getProgrammers() {
        return repository.findAllProgrammers();
    }

    @GetMapping("/programmers/{id}")
    public Programmer getProgrammerById(@PathVariable Long id) {
        return repository.getProgrammerById(id);
    }

    @GetMapping("/programmers/{id}/tasks")
    public List<Task> getTasksByProgrammer(@PathVariable Long id) {
        return repository.getTasksByProgrammer(id);
    }

    @PutMapping("/programmers/{idProgrammer}/tasks/{idTask}")
    public Programmer addTask(@PathVariable Long idProgrammer, @PathVariable Long idTask) {
        return repository.addTask(idProgrammer, idTask);
    }

    @PostMapping("/programmer")
    public boolean addProgrammer(@RequestBody Programmer programmer) {
        return repository.addProgrammer(programmer);
    }

    @DeleteMapping("/programmers/{idProgrammer}/tasks/{idTask}")
    public Programmer deleteTask(@PathVariable Long idProgrammer, @PathVariable Long idTask) {
        return repository.deleteTask(idProgrammer, idTask);
    }
}
