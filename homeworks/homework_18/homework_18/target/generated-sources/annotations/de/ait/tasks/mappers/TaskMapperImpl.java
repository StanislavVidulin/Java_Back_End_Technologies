package de.ait.tasks.mappers;

import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.model.Task;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T12:59:40+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskResponseDto toResponseDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskResponseDto taskResponseDto = new TaskResponseDto();

        taskResponseDto.setId( task.getId() );
        taskResponseDto.setDescription( task.getDescription() );
        taskResponseDto.setPriority( task.getPriority() );

        return taskResponseDto;
    }

    @Override
    public List<TaskResponseDto> toResponseDtoList(List<Task> task) {
        if ( task == null ) {
            return null;
        }

        List<TaskResponseDto> list = new ArrayList<TaskResponseDto>( task.size() );
        for ( Task task1 : task ) {
            list.add( toResponseDto( task1 ) );
        }

        return list;
    }

    @Override
    public Task fromRequestDto(TaskRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Task task = new Task();

        task.setDescription( dto.getDescription() );
        task.setPriority( dto.getPriority() );

        return task;
    }
}
