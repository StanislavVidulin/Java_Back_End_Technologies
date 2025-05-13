package de.ait.homework_15.service;

import de.ait.homework_15.dto.ProgrammerDto;
import de.ait.homework_15.model.Programmer;
import de.ait.homework_15.model.Task;

import java.util.List;

public interface ProgrammerService {
    List<ProgrammerDto> getAllProgrammers();
    ProgrammerDto getProgrammerById(Long id);
    List<Task> findTasksByProgrammerId(Long programmerId);
    void addTaskToProgrammer(Long programmerId, Long taskId);
    ProgrammerDto save(ProgrammerDto programmerDto);
    void deleteTaskToProgrammer(Long programmerId, Long taskId);
}