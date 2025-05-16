package de.ait.userapi.service;

import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.exceptions.UserNotFoundException;
import de.ait.userapi.mappers.UserMapper;
import de.ait.userapi.model.User;
import de.ait.userapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserResponseDto> getAllUsers() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserResponseDto addUser(UserRequestDto dto) {
        User user = mapper.toUser(dto);
        User savedUser = repository.save(user);
        return mapper.toResponseDto(savedUser);
    }
}

