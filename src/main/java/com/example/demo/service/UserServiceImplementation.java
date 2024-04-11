package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements IUserService {

    private final IUserRepository userRepository;

    UserServiceImplementation(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (this.userRepository.existsById(id)) {
            user.setId(id);
            return this.userRepository.save(user);
        }
        return null;
    }

    @Override
    public User getById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

}
