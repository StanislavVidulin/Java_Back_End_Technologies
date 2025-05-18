package de.ait.tasks.service;

import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.mappers.ProgrammerMapper;
import de.ait.tasks.mappers.TaskMapper;
import de.ait.tasks.model.Programmer;
import de.ait.tasks.model.Task;
import de.ait.tasks.repository.ProgrammerRepository;
import de.ait.tasks.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ProgrammerServiceImpl implements ProgrammerService {
    private final ProgrammerRepository programmerRepository;
    private final TaskRepository taskRepository;
    private final ProgrammerMapper programmerMapper;
    private final TaskMapper taskMapper;


    @Override
    public List<ProgrammerResponseDto> getAllProgrammers() {
        return programmerMapper.toResponseDtoList(programmerRepository.findAll());
    }

    @Override
    public ProgrammerResponseDto getProgrammerById(Long id) {
        return programmerMapper.toResponseDto(programmerRepository.findById(id).orElseThrow(() -> new RuntimeException("Programmer not found")));
    }

    @Override
    public ProgrammerResponseDto createProgrammer(ProgrammerRequestDto taskRequestDto) {
        Programmer programmer = programmerMapper.fromRequestDto(taskRequestDto);
        Programmer savedProgrammer = programmerRepository.save(programmer);
        return programmerMapper.toResponseDto(savedProgrammer);
    }

    @Override
    public void deleteProgrammer(Long id) {
        Programmer programmer = programmerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programmer not found"));
        programmerRepository.deleteById(programmer.getId());
    }

    @Override
    public ProgrammerResponseDto addTaskToProgrammer(Long programmerId, Long taskId) {
        Programmer programmer = programmerRepository.findById(programmerId)
                .orElseThrow(() -> new RuntimeException("Programmer not found"));
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setProgrammer(programmer);
        taskRepository.save(task);
        programmer.addTask(task);
        programmerRepository.save(programmer);
        return programmerMapper.toResponseDto(programmer);
    }

    @Override
    public ProgrammerResponseDto deleteTaskFromProgrammer(Long programmerId, Long taskId) {
        Programmer programmer = programmerRepository.findById(programmerId)
                .orElseThrow(() -> new RuntimeException("Programmer not found"));
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        programmer.removeTask(task);
        task.setProgrammer(null);
        taskRepository.save(task);
        programmerRepository.save(programmer);
        return programmerMapper.toResponseDto(programmer);
    }

    @Override
    public List<TaskResponseDto> findTasksByProgrammerId(Long idProgrammer) {
        Programmer programmer = programmerRepository.findById(idProgrammer)
                .orElseThrow(() -> new RuntimeException("Programmer not found"));
        return taskMapper.toResponseDtoList(programmer.getTasks().stream().toList());
    }
}
