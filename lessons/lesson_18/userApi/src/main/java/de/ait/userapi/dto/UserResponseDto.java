package de.ait.userapi.dto;

import de.ait.userapi.model.Address;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private Address address;
}
