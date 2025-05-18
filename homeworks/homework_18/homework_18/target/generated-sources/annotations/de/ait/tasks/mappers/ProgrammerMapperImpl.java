package de.ait.tasks.mappers;

import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.model.Programmer;
import de.ait.tasks.model.Task;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-18T16:24:14+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class ProgrammerMapperImpl implements ProgrammerMapper {

    @Override
    public ProgrammerResponseDto toResponseDto(Programmer programmer) {
        if ( programmer == null ) {
            return null;
        }

        ProgrammerResponseDto programmerResponseDto = new ProgrammerResponseDto();

        programmerResponseDto.setId( programmer.getId() );
        programmerResponseDto.setName( programmer.getName() );
        programmerResponseDto.setTasks( taskSetToTaskResponseDtoSet( programmer.getTasks() ) );

        return programmerResponseDto;
    }

    @Override
    public List<ProgrammerResponseDto> toResponseDtoList(List<Programmer> programmer) {
        if ( programmer == null ) {
            return null;
        }

        List<ProgrammerResponseDto> list = new ArrayList<ProgrammerResponseDto>( programmer.size() );
        for ( Programmer programmer1 : programmer ) {
            list.add( toResponseDto( programmer1 ) );
        }

        return list;
    }

    @Override
    public Programmer fromRequestDto(ProgrammerRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Programmer programmer = new Programmer();

        programmer.setName( dto.getName() );

        return programmer;
    }

    protected TaskResponseDto taskToTaskResponseDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskResponseDto taskResponseDto = new TaskResponseDto();

        taskResponseDto.setId( task.getId() );
        taskResponseDto.setDescription( task.getDescription() );
        taskResponseDto.setPriority( task.getPriority() );

        return taskResponseDto;
    }

    protected Set<TaskResponseDto> taskSetToTaskResponseDtoSet(Set<Task> set) {
        if ( set == null ) {
            return null;
        }

        Set<TaskResponseDto> set1 = new LinkedHashSet<TaskResponseDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Task task : set ) {
            set1.add( taskToTaskResponseDto( task ) );
        }

        return set1;
    }
}
