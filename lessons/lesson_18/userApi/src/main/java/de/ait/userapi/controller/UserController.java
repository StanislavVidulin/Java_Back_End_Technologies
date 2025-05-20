package de.ait.userapi.controller;

import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.exceptions.BadRoleException;
import de.ait.userapi.exceptions.UserNotFoundException;
import de.ait.userapi.model.User;
import de.ait.userapi.repository.UserRepository;
import de.ait.userapi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final Logger logger;
    private final UserService service;

    // Get /users?role=admin - отбор по роли
    // Get /users            - все
    @GetMapping("/users")
    public List<UserResponseDto> getUsers(@RequestParam(name = "role", required = false) String role) {
        logger.info(role);
        if (role == null || role.isBlank()) {
            return service.getAllUsers();
        } else {
            return service.getUsersByRole(role);
        }
    }

    @GetMapping("/users/{id}")
    public UserResponseDto getById(@PathVariable(name = "id") Long userId){
        return service.getUserById(userId);
    }

    @PostMapping("/users")
    public UserResponseDto addUser(@RequestBody UserRequestDto dto){
        logger.info(dto);
        return service.addUser(dto);
    }

    // Назначить роль пользователя
    // GET user/1/roles/role=admin
    @PostMapping("users/{id}/roles")
    public ResponseEntity<UserResponseDto> assignRole(@PathVariable Long id, @RequestParam(name = "role") String role) {
        try {
            UserResponseDto userResponseDto = service.assignRole(id, role);
            return ResponseEntity.ok(userResponseDto);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (BadRoleException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
