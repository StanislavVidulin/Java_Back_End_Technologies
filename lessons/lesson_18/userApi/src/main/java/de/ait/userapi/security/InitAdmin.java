package de.ait.userapi.security;

import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitAdmin implements CommandLineRunner {
    @Value("${app.admin.username:admin}")  // если в properties не прописать, то будет по дефолту "admin"
    private String adminUserName;
    @Value("${app.admin.password:qwerty}") // если в properties не прописать, то будет по дефолту "qwerty"
    private String adminUserPass;
    private final UserService service;

    @Override
    public void run(String... args) throws Exception {
        if (service.getUsersByRole("ADMIN").size() == 0) {
           UserResponseDto userResponseDto = service.addUser(new UserRequestDto(adminUserName, adminUserName, adminUserPass, null));
           if (userResponseDto == null) {
               throw new RuntimeException("Create ADMIN error");
           }
           service.assignRole(userResponseDto.getId(), "ADMIN");
        }
    }
}
