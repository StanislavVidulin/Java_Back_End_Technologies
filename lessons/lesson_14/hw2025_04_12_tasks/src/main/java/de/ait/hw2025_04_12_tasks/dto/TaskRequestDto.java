package de.ait.hw2025_04_12_tasks.dto;

import de.ait.hw2025_04_12_tasks.model.Priority;
import lombok.*;


@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class TaskRequestDto {
    private String description;
    private Priority priority;
}
