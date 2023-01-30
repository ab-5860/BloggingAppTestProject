package com.testProject.BloggingApp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testProject.BloggingApp.entities.User;

// public interface UserRepository extends JpaRepository<User, Integer> {
public interface UserRepository extends MongoRepository<User, Integer> {

}
