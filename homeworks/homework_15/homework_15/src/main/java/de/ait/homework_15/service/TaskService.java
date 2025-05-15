package de.ait.homework_15.service;

import de.ait.homework_15.dto.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAllTasks();
    TaskDto getTaskById(Long id);
    boolean deleteTaskById(Long id);
    TaskDto addTask(TaskDto dto);
}
