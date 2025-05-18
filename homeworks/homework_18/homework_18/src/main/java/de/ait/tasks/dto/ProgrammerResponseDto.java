package de.ait.tasks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProgrammerResponseDto {
    private Long id;
    private String name;
    private Set<TaskResponseDto> tasks;
}
