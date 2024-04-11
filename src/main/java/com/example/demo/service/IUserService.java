package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);
    User updateUser(Long id, User user);
    User getById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
}
