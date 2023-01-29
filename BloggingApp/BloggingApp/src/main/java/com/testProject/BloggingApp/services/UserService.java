package com.testProject.BloggingApp.services;

import java.util.List;

import com.testProject.BloggingApp.dtos.UserDto;

public interface UserService {

    // create
    UserDto addUser(UserDto userDto);

    // update
    UserDto updateUser(UserDto userDto);

    // delete
    void deleteUser();

    // get all users
    List<UserDto> getAllUser();

    // get a user
    UserDto getUser(int userId);

}
