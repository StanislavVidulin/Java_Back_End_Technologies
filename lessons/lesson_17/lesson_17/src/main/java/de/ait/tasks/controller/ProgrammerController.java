package de.ait.tasks.controller;

import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.model.Programmer;
import de.ait.tasks.model.Task;
import de.ait.tasks.repository.ProgrammerRepository;
import de.ait.tasks.repository.ProgrammerRepositoryMapImpl;
import de.ait.tasks.service.ProgrammerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@AllArgsConstructor
public class ProgrammerController {

    private final ProgrammerRepository repository;
    private final ProgrammerService service;



    @GetMapping("/programmers")
    public List<ProgrammerResponseDto> getProgrammers(){
        return service.getAllProgrammer();
    }

    @GetMapping("/programmers/{id}")
    public Programmer getProgrammerById(@PathVariable("id") Long id){
        return repository.findById(id);
    }


    //получить список задач заданного программиста (GET programmers/id/tasks)
    @GetMapping("/programmers/{id}/tasks")
    public List<Task> getTaskByProgrammer(@PathVariable("id") Long id){
        return repository.findTasksByProgrammerId(id);
    }

    //поручить программисту задачу (PUT programmers/programmerId/tasks/taskId)
    @PutMapping("/programmers/{programmerId}/tasks/{taskId}")
    public void addTaskToProgrammer(@PathVariable("programmerId") Long programmerID, @PathVariable("taskId") Long taskId){
        repository.addTaskToProgrammer(programmerID,taskId);
    }

}
