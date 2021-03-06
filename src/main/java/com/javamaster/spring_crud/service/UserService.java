package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.UserDto;
import com.javamaster.spring_crud.exception.ValidationException;

import java.util.List;

public interface UserService {

    UserDto saveUser(UserDto userDto) throws ValidationException;

    void deleteUser(Integer userId);

    UserDto findByLogin(String login);

    List<UserDto> findAll();

    UserDto updateUser(UserDto userDto) throws ValidationException;
}
