package de.ait.homework_16.mappers;

import de.ait.homework_16.dto.ProgrammerDto;
import de.ait.homework_16.model.Programmer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T13:04:25+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class ProgrammerMapperImpl implements ProgrammerMapper {

    @Override
    public Programmer toProgrammer(ProgrammerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Programmer programmer = new Programmer();

        programmer.setName( dto.getName() );

        return programmer;
    }

    @Override
    public ProgrammerDto toProgrammerDto(Programmer programmer) {
        if ( programmer == null ) {
            return null;
        }

        String name = null;

        name = programmer.getName();

        ProgrammerDto programmerDto = new ProgrammerDto( name );

        return programmerDto;
    }

    @Override
    public List<ProgrammerDto> toListProgrammerDto(List<Programmer> programmers) {
        if ( programmers == null ) {
            return null;
        }

        List<ProgrammerDto> list = new ArrayList<ProgrammerDto>( programmers.size() );
        for ( Programmer programmer : programmers ) {
            list.add( toProgrammerDto( programmer ) );
        }

        return list;
    }
}
