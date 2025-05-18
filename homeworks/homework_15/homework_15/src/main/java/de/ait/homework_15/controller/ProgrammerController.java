package de.ait.homework_15.controller;

import de.ait.homework_15.dto.ProgrammerDto;
import de.ait.homework_15.model.Programmer;
import de.ait.homework_15.model.Task;
import de.ait.homework_15.repository.ProgrammerRepository;
import de.ait.homework_15.service.ProgrammerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProgrammerController {

    private final ProgrammerService service;

    @GetMapping("/programmers")
    public List<ProgrammerDto> getProgrammers() {
        return service.getAllProgrammers();
    }

    @GetMapping("/programmers/{id}")
    public ProgrammerDto getProgrammerById(@PathVariable("id") Long id) {
        return service.getProgrammerById(id);
    }

    // получить список задач заданного программиста (GET programmers/id/tasks)
    @GetMapping("/programmers/{id}/tasks")
    public List<Task> getTaskByProgrammer(@PathVariable("id") Long id) {
        return service.findTasksByProgrammerId(id);
    }

    //поручить программисту задачу (PUT programmers/programmerId/tasks/taskId)
    @PutMapping("/programmers/{programmerId}/tasks/{taskId}")
    public void addTaskToProgrammer(@PathVariable("programmerId") Long programmerId, @PathVariable("taskId") Long taskId) {
        service.addTaskToProgrammer(programmerId, taskId);
    }

    @PostMapping("/programmer")
    public ProgrammerDto addProgrammer(@RequestBody ProgrammerDto programmerDto) {
        return service.save(programmerDto);
    }

    @DeleteMapping("/programmers/{idProgrammer}/tasks/{idTask}")
    public void deleteProgrammer(@PathVariable Long idProgrammer, @PathVariable Long idTask) {
        service.deleteTaskToProgrammer(idProgrammer, idTask);
    }
}
