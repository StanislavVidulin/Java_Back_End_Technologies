package de.ait.tasks.repository;

import de.ait.tasks.model.Programmer;
import de.ait.tasks.model.Task;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository


public class ProgrammerRepositoryMapImpl implements ProgrammerRepository {
    private final TaskRepository taskRepository;
    private static Long lastID = 3L;
    private static Map<Long, Programmer> map = new HashMap<>();

    public ProgrammerRepositoryMapImpl(@Qualifier("taskRepositoryMapImpl") TaskRepository taskRepository) {
        map.put(1L, new Programmer(1L,"Jack") );
        map.put(2L, new Programmer(2L,"Nick") );
        map.put(3L, new Programmer(3L,"John") );
        this.taskRepository = taskRepository;
        addTaskToProgrammer(1l,1l);
        addTaskToProgrammer(1l,2l);
        addTaskToProgrammer(2l,3l);
    }






    @Override
    public List<Programmer> findAll() {
        return map.values().stream().toList();
    }

    @Override
    public Programmer findById(Long id) {
        return map.get(id);
    }

    @Override
    public Programmer save(Programmer programmer) {
         programmer.setId(++lastID);
         map.put(lastID, programmer);
        return programmer;
    }

    @Override
    public void addTaskToProgrammer(Long programmerId, Long taskId) {
        try {
            Task task = taskRepository.findById(taskId);
            Programmer programmer = map.get(programmerId);
            if (programmer!=null){
                programmer.addTask(task);
            } else{
                throw  new RuntimeException("Programmer not found");
            }
        } catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void deleteTaskToProgrammer(Long programmerId, Long taskId) {
        Programmer programmer = findById(programmerId);
        Task task = taskRepository.findById(taskId);
        programmer.removeTask(task);

    }

    @Override
    public List<Task> findTasksByProgrammerId(Long id) {
        return new ArrayList<>(findById(id).getTasks());
    }
}
