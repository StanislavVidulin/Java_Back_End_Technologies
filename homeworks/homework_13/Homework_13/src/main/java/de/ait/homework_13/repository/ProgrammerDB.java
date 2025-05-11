package de.ait.homework_13.repository;

import de.ait.homework_13.exceptions.ProgrammerNotFoundException;
import de.ait.homework_13.model.Programmer;
import de.ait.homework_13.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ProgrammerDB implements ProgrammerRepository{

    private final TaskRepository taskDB;
    private static HashMap<Long, Programmer> programmers = new HashMap<>();

    static {
        programmers.put(1L, new Programmer(1L, "John", new ArrayList<>()));
        programmers.put(2L, new Programmer(2L, "Steve", new ArrayList<>()));
        programmers.put(3L, new Programmer(3L, "Harry", new ArrayList<>()));
        programmers.put(4L, new Programmer(4L, "Thomas", new ArrayList<>()));
        programmers.put(5L, new Programmer(5L, "Peter", new ArrayList<>()));
    }

    @Autowired
    public ProgrammerDB(TaskRepository taskDB) {
        this.taskDB = taskDB;
    }

    @Override
    public List<Programmer> findAllProgrammers() {
        return programmers.values().stream().toList();
    }

    @Override
    public Programmer getProgrammerById(Long id) {
        return programmers.get(id);
    }

    @Override
    public List<Task> getTasksByProgrammer(Long id) {
        return programmers.get(id).getTasks();
    }

    @Override
    public Programmer addTask(Long idProgrammer, Long idTask) {
        Programmer programmer = programmers.get(idProgrammer);
        if (programmer == null) {
            throw new ProgrammerNotFoundException();
        }
        Task task = taskDB.findById(idTask);
        programmer.getTasks().add(task);
        return programmer;

    }

    @Override
    public boolean addProgrammer(Programmer programmer) {
        return programmers.put(programmer.getId(), programmer) != null;
    }

    @Override
    public Programmer deleteTask(Long idProgrammer, Long idTask) {
        Programmer programmer = programmers.get(idProgrammer);
        if (programmer == null) {
            throw new ProgrammerNotFoundException();
        }
        Task task = taskDB.findById(idTask);
        programmer.getTasks().remove(task);
        return programmer;
    }
}
