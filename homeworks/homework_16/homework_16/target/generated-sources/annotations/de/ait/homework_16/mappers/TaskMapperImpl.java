package de.ait.homework_16.mappers;

import de.ait.homework_16.dto.TaskDto;
import de.ait.homework_16.model.Task;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T13:04:24+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public List<TaskDto> toListTaskDto(List<Task> tasks) {
        if ( tasks == null ) {
            return null;
        }

        List<TaskDto> list = new ArrayList<TaskDto>( tasks.size() );
        for ( Task task : tasks ) {
            list.add( toTaskDto( task ) );
        }

        return list;
    }

    @Override
    public TaskDto toTaskDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        taskDto.setDescription( task.getDescription() );
        taskDto.setPriority( task.getPriority() );

        return taskDto;
    }

    @Override
    public Task toTask(TaskDto dto) {
        if ( dto == null ) {
            return null;
        }

        Task task = new Task();

        task.setDescription( dto.getDescription() );
        task.setPriority( dto.getPriority() );

        return task;
    }
}
