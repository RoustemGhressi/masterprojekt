package com.roustem.userService.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.roustem.userService.entity.User;

public interface UserDao extends MongoRepository<User, String> {

    User findUserByUserId(String userId);

    User findUserByEmail(String email);
}
