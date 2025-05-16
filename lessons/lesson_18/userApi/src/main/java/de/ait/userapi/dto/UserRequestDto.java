package de.ait.userapi.dto;

import de.ait.userapi.model.Address;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private Address address;
}
