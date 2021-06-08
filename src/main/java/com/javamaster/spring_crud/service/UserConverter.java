package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.UserDto;
import com.javamaster.spring_crud.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User fromUserToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setLogin(userDto.getLogin());
        return user;
    }

    public static UserDto fromUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .login(user.getLogin())
                .name(user.getName())
                .build();
    }


    }


