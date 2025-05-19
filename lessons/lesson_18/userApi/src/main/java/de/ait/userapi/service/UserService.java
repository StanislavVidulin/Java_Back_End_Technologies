package de.ait.userapi.service;

import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);

    UserResponseDto addUser(UserRequestDto dto);

    public List<UserResponseDto> getUsersByRole(String strRole);
    public UserResponseDto assignRole(Long userId, String strRole);
    public UserResponseDto removeRole(Long userId, String strRole);
}
