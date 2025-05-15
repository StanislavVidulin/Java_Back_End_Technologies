package de.ait.homework_15.dto;

import de.ait.homework_15.model.Priority;
import lombok.*;

@AllArgsConstructor
@Getter
public class TaskDto {
    private String description;
    private Priority priority;
}
