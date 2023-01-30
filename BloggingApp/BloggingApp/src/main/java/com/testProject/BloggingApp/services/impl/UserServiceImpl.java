package com.testProject.BloggingApp.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testProject.BloggingApp.dtos.UserDto;
import com.testProject.BloggingApp.entities.User;
import com.testProject.BloggingApp.repositories.UserRepository;
import com.testProject.BloggingApp.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);

        User savedUser = this.userRepository.save(user);

        return this.modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteUser() {
        // TODO Auto-generated method stub

    }

    @Override
    public List<UserDto> getAllUser() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDto getUser(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

}
