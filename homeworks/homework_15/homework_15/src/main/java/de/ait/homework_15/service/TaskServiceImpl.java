package de.ait.homework_15.service;

import de.ait.homework_15.dto.TaskDto;
import de.ait.homework_15.exceptions.TaskNotFoundException;
import de.ait.homework_15.model.Task;
import de.ait.homework_15.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    public TaskServiceImpl(@Qualifier("taskRepositoryMapImpl") TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return repository.findAll()
                .stream()
                .map(TaskServiceImpl::createTaskDto)
                .toList();
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = repository.findById(id);
        if (task != null) {
            return createTaskDto(task);
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
        Task task = new Task(null, dto.getDescription(), dto.getPriority());
        Task savedTask = repository.save(task);
        if (savedTask != null) {
            return new TaskDto(dto.getDescription(), dto.getPriority());
        } else {
            throw new TaskNotFoundException();
        }
    }

    private static TaskDto createTaskDto(Task task) {
        return new TaskDto(task.getDescription(), task.getPriority());
    }
}
