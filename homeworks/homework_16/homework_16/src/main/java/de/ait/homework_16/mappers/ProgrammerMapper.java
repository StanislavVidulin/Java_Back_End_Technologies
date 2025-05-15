package de.ait.homework_16.mappers;

import de.ait.homework_16.dto.ProgrammerDto;
import de.ait.homework_16.model.Programmer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    Programmer toProgrammer(ProgrammerDto dto);
    ProgrammerDto toProgrammerDto(Programmer programmer);
    List<ProgrammerDto> toListProgrammerDto (List<Programmer> programmers);
}
