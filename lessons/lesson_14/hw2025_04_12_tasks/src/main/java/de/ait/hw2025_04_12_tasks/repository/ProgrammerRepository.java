package de.ait.hw2025_04_12_tasks.repository;

import de.ait.hw2025_04_12_tasks.model.Programmer;
import de.ait.hw2025_04_12_tasks.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProgrammerRepository {
    List<Programmer> findAll();
    Programmer findById(Long id);
    Programmer save(Programmer programmer);

    void addTaskToProgrammer(Long programmerId, Long taskId);
    void deleteTaskToProgrammer(Long programmerId, Long taskId);
    List<Task> findTasksByProgrammerId(Long id);
}
