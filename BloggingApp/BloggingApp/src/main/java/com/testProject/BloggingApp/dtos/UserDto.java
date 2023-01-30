package com.testProject.BloggingApp.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private int userId;

    @NotEmpty(message = "Username cannot be empty !!")
    @Size(min = 3, max = 10, message = "Username should be in range of 3 to 10")
    private String username;

    @NotEmpty(message = "Email is a mandatory field!!")
    @Email(message = "Please enter a valid email!!", regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}")
    private String email;

    private String about;

}