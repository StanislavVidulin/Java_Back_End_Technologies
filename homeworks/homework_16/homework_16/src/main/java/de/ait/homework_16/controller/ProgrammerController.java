package de.ait.homework_16.controller;

import de.ait.homework_16.dto.ProgrammerDto;
import de.ait.homework_16.model.Task;
import de.ait.homework_16.service.ProgrammerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProgrammerController {

    private final ProgrammerService service;

    @GetMapping("/programmers")
    public ResponseEntity<List<ProgrammerDto>> getProgrammers() {
        List<ProgrammerDto> allProgrammers = service.getAllProgrammers();
        return new ResponseEntity<>(allProgrammers, HttpStatus.OK);
    }

    @GetMapping("/programmers/{id}")
    public ResponseEntity<ProgrammerDto> getProgrammerById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(service.getProgrammerById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // получить список задач заданного программиста (GET programmers/id/tasks)
    @GetMapping("/programmers/{id}/tasks")
    public ResponseEntity<List<Task>> getTaskByProgrammer(@PathVariable("id") Long id) {
        try {
            List<Task> tasks = service.findTasksByProgrammerId(id);
            if (tasks.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(tasks);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //поручить программисту задачу (PUT programmers/programmerId/tasks/taskId)
    @PutMapping("/programmers/{programmerId}/tasks/{taskId}")
    public ResponseEntity<Void> addTaskToProgrammer(@PathVariable("programmerId") Long programmerId, @PathVariable("taskId") Long taskId) {
        try {
            service.addTaskToProgrammer(programmerId, taskId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/programmer")
    public ResponseEntity<ProgrammerDto> addProgrammer(@RequestBody ProgrammerDto programmerDto) {
        try {
            service.save(programmerDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/programmers/{idProgrammer}/tasks/{idTask}")
    public ResponseEntity<Void> deleteProgrammer(@PathVariable Long idProgrammer, @PathVariable Long idTask) {
        try {
            service.deleteTaskToProgrammer(idProgrammer, idTask);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
