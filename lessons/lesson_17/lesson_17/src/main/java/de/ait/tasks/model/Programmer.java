package de.ait.tasks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
public class Programmer {
    private Long id;
    private String name;
    private Set<Task> tasks;

    public Programmer(Long id, String name) {
        this.id = id;
        this.name = name;
        this.tasks = new HashSet<>();
    }

    public void addTask(Task task){
        tasks.add(task);
    }
    public void removeTask(Task task){
        tasks.remove(task);
    }

}
