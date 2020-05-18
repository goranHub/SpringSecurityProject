package com.example.controller;



import com.example.model.User;
import com.example.data.Implementation.UserDetailsManagerImpl;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserDetailsManagerImpl userDetailsManager;


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_DEVELOPER')")
    @GetMapping(path = "{id}")
    public User getUser(@PathVariable("id") int userId) {
        return userService.getUserbyID(userId);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    void insertUser(@RequestBody User user) {
        userService.addNewUser(user);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_DEVELOPER')")
    @PutMapping(path = "{id}")
    void updateUser(@PathVariable("id") int userId, @RequestBody User user) {
        userService.updateUser(userId, user);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") int userId) {
        userService.deleteUser(userId);
    }


}

