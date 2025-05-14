package de.ait.homework_13.repository;

import de.ait.homework_13.model.Programmer;
import de.ait.homework_13.model.Task;

import java.util.List;

public interface ProgrammerRepository {
    public List<Programmer> findAllProgrammers();
    public Programmer getProgrammerById(Long id);
    public List<Task> getTasksByProgrammer(Long id);
    public Programmer addTask(Long idProgrammer, Long idTask);
    public boolean addProgrammer(Programmer programmer);
    public Programmer deleteTask(Long idProgrammer, Long idTask);
}
