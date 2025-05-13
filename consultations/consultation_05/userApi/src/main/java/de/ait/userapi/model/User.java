package de.ait.userapi.model;

import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class User {
    @Setter
    private Long id;
    private String name;
    private String email;
    private String password;
}
