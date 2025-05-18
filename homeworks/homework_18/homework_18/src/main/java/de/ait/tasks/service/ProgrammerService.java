package de.ait.tasks.service;

import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.dto.TaskResponseDto;

import java.util.List;

public interface ProgrammerService {
    List<ProgrammerResponseDto> getAllProgrammers();
    ProgrammerResponseDto getProgrammerById(Long id);
    ProgrammerResponseDto createProgrammer(ProgrammerRequestDto taskRequestDto);
    void deleteProgrammer(Long id);

    ProgrammerResponseDto addTaskToProgrammer(Long programmerId, Long taskId);
    ProgrammerResponseDto deleteTaskFromProgrammer(Long programmerId, Long taskId);
    List<TaskResponseDto> findTasksByProgrammerId(Long idProgrammer);
}