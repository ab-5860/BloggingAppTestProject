package com.testProject.BloggingApp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testProject.BloggingApp.dtos.UserDto;
import com.testProject.BloggingApp.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    // create
    @PostMapping("")
    ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

        UserDto addedUser = this.userService.addUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedUser);
    }

    // update
    @PutMapping("/update")
    ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto) {
        UserDto updatedUser = this.userService.updateUser(userDto);

        return ResponseEntity.ok(updatedUser);
    }

    // delete
    @DeleteMapping("/{userId}")
    ResponseEntity<Map<String, String>> deleteUser(@PathVariable int userId) {
        this.userService.deleteUser(userId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "User deleted successfully!!");
        response.put("success", "true");

        return ResponseEntity.ok(response);
    }

    // get all users
    @GetMapping("")
    ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> allUsers = this.userService.getAllUser();
        return ResponseEntity.ok(allUsers);
    }

    // get a user
    @GetMapping("/{userId}")
    ResponseEntity<UserDto> getUser(@PathVariable int userId) {
        UserDto user = this.userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

}
