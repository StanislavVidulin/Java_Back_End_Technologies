package de.ait.homework_15.service;

import de.ait.homework_15.dto.ProgrammerDto;
import de.ait.homework_15.exceptions.ProgrammerNotFoundException;
import de.ait.homework_15.model.Programmer;
import de.ait.homework_15.model.Task;
import de.ait.homework_15.repository.ProgrammerRepository;
import de.ait.homework_15.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {
    private final ProgrammerRepository programmerRepository;
    private final TaskRepository taskRepository;

    public ProgrammerServiceImpl(ProgrammerRepository programmerRepository, @Qualifier("taskRepositoryMapImpl") TaskRepository taskRepository) {
        this.programmerRepository = programmerRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public ProgrammerDto save(ProgrammerDto programmerDto) {
        Programmer programmer = new Programmer(null, programmerDto.getName());
        Programmer savedProgrammer = programmerRepository.save(programmer);
        if (savedProgrammer != null) {
            return new ProgrammerDto(programmerDto.getName());
        } else {
            throw new ProgrammerNotFoundException();
        }
    }

    @Override
    public void deleteTaskToProgrammer(Long programmerId, Long taskId) {
        programmerRepository.deleteTaskToProgrammer(programmerId, taskId);
    }


    @Override
    public List<ProgrammerDto> getAllProgrammers() {
        return programmerRepository.findAll()
                .stream()
                .map(ProgrammerServiceImpl::createDto)
                .toList();
    }

    @Override
    public ProgrammerDto getProgrammerById(Long id) {
        Programmer programmer = programmerRepository.findById(id);
        if (programmer != null) {
            return new ProgrammerDto(programmer.getName());
        } else {
            throw new ProgrammerNotFoundException();
        }
    }


    @Override
    public List<Task> findTasksByProgrammerId(Long programmerId) {
        return programmerRepository.findTasksByProgrammerId(programmerId);
    }

    @Override
    public void addTaskToProgrammer(Long programmerId, Long taskId) {
        Programmer programmer = programmerRepository.findById(programmerId);
        Task task = taskRepository.findById(taskId);
        if (programmer != null) {
            programmer.addTask(task);
        } else {
            throw new RuntimeException();
        }
    }

    private static ProgrammerDto createDto(Programmer programmer) {
        return new ProgrammerDto(programmer.getName());
    }
}
