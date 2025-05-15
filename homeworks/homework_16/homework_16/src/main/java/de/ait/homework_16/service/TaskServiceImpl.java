package de.ait.homework_16.service;

import de.ait.homework_16.dto.TaskDto;
import de.ait.homework_16.exceptions.TaskNotFoundException;
import de.ait.homework_16.mappers.TaskMapper;
import de.ait.homework_16.model.Task;
import de.ait.homework_16.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;
    private final TaskMapper mapper;

    public TaskServiceImpl(@Qualifier("taskRepositoryMapImpl") TaskRepository repository, TaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return mapper.toListTaskDto(repository.findAll());
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = repository.findById(id);
        if (task != null) {
            return mapper.toTaskDto(task);
        } else {
            throw new TaskNotFoundException();
        }
    }

    @Override
    public boolean deleteTaskById(Long id) {
        Task task = repository.findById(id);
        if (task != null) {
            repository.delete(task.getId());
            return true;
        } else {
            throw new TaskNotFoundException();
        }
    }

    @Override
    public TaskDto addTask(TaskDto dto) {
        Task task = mapper.toTask(dto);
        Task savedTask = repository.save(task);
        if (savedTask != null) {
            return mapper.toTaskDto(savedTask);
        } else {
            throw new TaskNotFoundException();
        }
    }
}
