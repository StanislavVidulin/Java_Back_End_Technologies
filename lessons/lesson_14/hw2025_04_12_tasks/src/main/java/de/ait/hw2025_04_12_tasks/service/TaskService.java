package de.ait.hw2025_04_12_tasks.service;

import de.ait.hw2025_04_12_tasks.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getAllTasks();
}
