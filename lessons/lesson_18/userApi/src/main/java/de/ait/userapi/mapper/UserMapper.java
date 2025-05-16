package de.ait.userapi.mapper;

import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromDto(UserRequestDto dto);
    UserResponseDto toDto (User user);
    List<UserResponseDto> toDtoList (List<User> user);
}
