package de.ait.tasks.mappers;


import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.model.Task;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskResponseDto toResponseDto(Task task);
    List<TaskResponseDto> toResponseDtoList(List<Task> task);
    Task fromRequestDto(TaskRequestDto dto);
}
