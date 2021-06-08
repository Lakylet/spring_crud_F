package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.UserDto;
import com.javamaster.spring_crud.entity.User;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultUserService implements UserService{


    private final UserRepository usersRepository;
    private final UserConverter userConverter;

    @Override
    public UserDto saveUser(UserDto userDto) throws ValidationException {
        validateUserDto(userDto);
        User savedUser = usersRepository.save(userConverter.fromUserToUser(userDto));
        return userConverter.fromUserToUserDto(savedUser);
    }


    private void validateUserDto(UserDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }



    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UserDto findByLogin(String login) {
        User users = usersRepository.findByLogin(login);
        if (users != null) {
            return UserConverter.fromUserToUserDto(users);
        }
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(UserConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }
    @Override
    public UserDto updateUser(UserDto userDto) throws ValidationException{
        validateUserDto(userDto);
        User updateUser = usersRepository.update(userConverter.fromUserToUser(userDto));
        return userConverter.fromUserToUserDto(updateUser);
    }
}
