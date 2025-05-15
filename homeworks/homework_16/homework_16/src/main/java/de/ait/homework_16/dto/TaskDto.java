package de.ait.homework_16.dto;

import de.ait.homework_16.model.Priority;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TaskDto {
    private String description;
    private Priority priority;
}
