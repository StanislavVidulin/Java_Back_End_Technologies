package de.ait.homework_16.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Task {
    private Long id;
    private String description;
    private Priority priority;
}