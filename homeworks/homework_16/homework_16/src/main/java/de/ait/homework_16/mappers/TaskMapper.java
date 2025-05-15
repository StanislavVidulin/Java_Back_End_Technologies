package de.ait.homework_16.mappers;

import de.ait.homework_16.dto.TaskDto;
import de.ait.homework_16.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    List<TaskDto> toListTaskDto(List<Task> tasks);
    TaskDto toTaskDto(Task task);
    Task toTask(TaskDto dto);
}
