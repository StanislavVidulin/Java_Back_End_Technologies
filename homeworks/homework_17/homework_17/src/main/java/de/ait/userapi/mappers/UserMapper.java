package de.ait.userapi.mappers;

import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface UserMapper {
    List<UserResponseDto> toResponseDtoList(List<User> users);
    UserResponseDto toResponseDto(User user);
    User toUser (UserRequestDto dto);
}
