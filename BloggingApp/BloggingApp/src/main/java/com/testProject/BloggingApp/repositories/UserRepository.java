package com.testProject.BloggingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testProject.BloggingApp.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
