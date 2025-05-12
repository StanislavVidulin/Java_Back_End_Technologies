package de.ait.hw2025_04_12_tasks.model;

import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Task {
    @Setter
    private Long id;
    private String description;
    private Priority priority;
}