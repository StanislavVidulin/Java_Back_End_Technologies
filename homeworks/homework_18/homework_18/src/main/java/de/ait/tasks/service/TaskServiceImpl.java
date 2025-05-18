package de.ait.tasks.service;

import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.mappers.TaskMapper;
import de.ait.tasks.model.Task;
import de.ait.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;
    private final TaskMapper mapper;


    @Override
    // return или значение TaskResponseDto или null
    public List<TaskResponseDto> getAllTasks() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        return mapper.toResponseDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found")));
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskDto) {
        Task task = mapper.fromRequestDto(taskDto);
        Task savedTask = repository.save(task);
        return mapper.toResponseDto(savedTask);
    }

    @Override
    public TaskResponseDto deleteTask(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        repository.deleteById(id);
        return mapper.toResponseDto(task);
    }
}
