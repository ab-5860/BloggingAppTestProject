package com.testProject.BloggingApp.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testProject.BloggingApp.dtos.UserDto;
import com.testProject.BloggingApp.entities.User;
import com.testProject.BloggingApp.exceptions.ResourceNotFoundException;
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
        // check if user present in db or not
        User user = this.userRepository.findById(userDto.getUserId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("User not found with id: " + userDto.getUserId()));

        // update if present
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());

        return this.modelMapper.map(this.userRepository.save(user), UserDto.class);
    }

    @Override
    public void deleteUser(int userId) {
        // check if user present in db or not
        User user = this.userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User not found with id: " + userId));

        this.userRepository.delete(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = this.userRepository.findAll();

        List<UserDto> userDtos = users.stream().map(user -> {
            return this.modelMapper.map(user, UserDto.class);
        }).collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public UserDto getUser(int userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User not found with id: " + userId));

        return this.modelMapper.map(user, UserDto.class);
    }

}
