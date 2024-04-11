package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PostUpdate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private IUserService userService;

    UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
       if(this.userService.getById(id) == null) {
           return null;
         }

        return this.userService.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        if(this.userService.getById(id) == null) {
            return "User with id:" +id+" not found!";
        }
        this.userService.deleteUser(id);
        return "User with id: "+id+" deleted successfully!";
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.userService.getById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }


}
