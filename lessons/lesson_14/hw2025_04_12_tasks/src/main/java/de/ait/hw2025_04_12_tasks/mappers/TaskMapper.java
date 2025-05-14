package de.ait.hw2025_04_12_tasks.mappers;

import de.ait.hw2025_04_12_tasks.dto.TaskResponseDto;
import de.ait.hw2025_04_12_tasks.model.Task;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskResponseDto toResponseDto(Task task);
    List<TaskResponseDto> toResponseDtoList(List<Task> tasks);
}
