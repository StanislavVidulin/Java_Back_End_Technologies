package de.ait.tasks.service;

import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.mappers.ProgrammerMapper;
import de.ait.tasks.repository.ProgrammerRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ProgrammerServiceImpl implements ProgrammerService {
    private final ProgrammerRepository repository;
    private final ProgrammerMapper mapper;

    @Override
    public List<ProgrammerResponseDto> getAllProgrammer() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    @Override
    public ProgrammerResponseDto getProgrammerById(Long id) {
        return null;
    }

    @Override
    public ProgrammerResponseDto createTask(ProgrammerRequestDto taskRequestDto) {
        return null;
    }

    @Override
    public ProgrammerResponseDto deleteTask(Long id) {
        return null;
    }
}
