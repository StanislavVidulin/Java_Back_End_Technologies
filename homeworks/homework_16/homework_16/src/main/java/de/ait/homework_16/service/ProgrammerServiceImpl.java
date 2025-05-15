package de.ait.homework_16.service;

import de.ait.homework_16.dto.ProgrammerDto;
import de.ait.homework_16.exceptions.ProgrammerNotFoundException;
import de.ait.homework_16.mappers.ProgrammerMapper;
import de.ait.homework_16.model.Programmer;
import de.ait.homework_16.model.Task;
import de.ait.homework_16.repository.ProgrammerRepository;
import de.ait.homework_16.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {
    private final ProgrammerRepository programmerRepository;
    private final TaskRepository taskRepository;
    private final ProgrammerMapper mapper;

    public ProgrammerServiceImpl(ProgrammerRepository programmerRepository, @Qualifier("taskRepositoryMapImpl") TaskRepository taskRepository, ProgrammerMapper mapper) {
        this.programmerRepository = programmerRepository;
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    @Override
    public ProgrammerDto save(ProgrammerDto programmerDto) {
        Programmer programmer = mapper.toProgrammer(programmerDto); // дто в сущность
        Programmer savedProgrammer = programmerRepository.save(programmer); // сохраняем сущность в репозиторий
        if (savedProgrammer != null) {
            return mapper.toProgrammerDto(savedProgrammer);// обратно сущность в dto
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
        return mapper.toListProgrammerDto(programmerRepository.findAll());
    }

    @Override
    public ProgrammerDto getProgrammerById(Long id) {
        Programmer programmer = programmerRepository.findById(id);
        if (programmer != null) {
            return mapper.toProgrammerDto(programmer);
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
}
