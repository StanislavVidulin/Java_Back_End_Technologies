package de.ait.tasks.controller;

import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.service.ProgrammerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/programmers")
public class ProgrammerController {
    private final ProgrammerService service;


    @GetMapping
    public ResponseEntity<List<ProgrammerResponseDto>> getProgrammers() {
        return ResponseEntity.ok(service.getAllProgrammers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgrammerResponseDto> getProgrammerById(@PathVariable("id") Long id) {
        ProgrammerResponseDto programmer = service.getProgrammerById(id);
        return ResponseEntity.ofNullable(programmer);
    }

    @PostMapping
    public ResponseEntity<ProgrammerResponseDto> addProgrammer(@RequestBody ProgrammerRequestDto dto) {
        ProgrammerResponseDto saved = service.createProgrammer(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgrammer(@PathVariable("id") Long id) {
        service.deleteProgrammer(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{programmerId}/tasks/{taskId}")
    public ResponseEntity<ProgrammerResponseDto> addTaskToProgrammer(@PathVariable("programmerId") Long programmerID,
                                                                     @PathVariable("taskId") Long taskId) {
        ProgrammerResponseDto saved = service.addTaskToProgrammer(programmerID, taskId);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{programmerId}/tasks/{taskId}")
    public ResponseEntity<ProgrammerResponseDto> deleteTaskFromProgrammer(@PathVariable("programmerId") Long programmerId,
                                                                          @PathVariable("taskId") Long taskId) {
        ProgrammerResponseDto updatedProgrammer = service.deleteTaskFromProgrammer(programmerId, taskId);
        return ResponseEntity.ok(updatedProgrammer);
    }

    //получить список задач заданного программиста (GET programmers/id/tasks)
    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<TaskResponseDto>> getTaskByProgrammer(@PathVariable("id") Long id) {
        List<TaskResponseDto> listTasks = service.findTasksByProgrammerId(id);
        return ResponseEntity.ok(listTasks);
    }
}
