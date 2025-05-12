package de.ait.hw2025_04_12_tasks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
public class Programmer {
    @Setter
    private Long id;
    private String name;
    private Set<Task> tasks;

    public Programmer(Long id, String name) {
        this.id = id;
        this.name = name;
        this.tasks = new HashSet<>();
    }

    public void addTask(Task task) {
//        if (tasks == null) {
//            tasks = new HashSet<>();
//        }
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
}