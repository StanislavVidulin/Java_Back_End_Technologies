package de.ait.tasks.service;

import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.model.Task;

import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto getTaskById(Long id);
    TaskResponseDto createTask(TaskRequestDto taskRequestDto);
    TaskResponseDto deleteTask(Long id);
}
