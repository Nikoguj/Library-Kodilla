package com.crud.library.mapper;

import com.crud.library.domain.User;
import com.crud.library.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(userDto.getName(), userDto.getSurname());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(user.getName(), user.getName());
    }
}