package com.example.service;


import com.example.controller.LoginController;
import com.example.data.UserDataAccessService;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserDataAccessService userDataAccessService;
    @Autowired
    private LoginController loginController;

    @Autowired
    public UserService(UserDataAccessService userDataAccessService) {
        this.userDataAccessService = userDataAccessService;
    }

    public List<User> getAllUsers() {

        return userDataAccessService.selectAllUsers();
    }


    public User getUserbyID(int userID) {
        return userDataAccessService.getUserbyID(userID);
    }


    public void addNewUser(User user) {
        userDataAccessService.setUser(user);
    }


    public void updateUser(int userId, User user) {
        userDataAccessService.updateUser(userId, user);
    }


    public boolean deleteUser(int userID) {
        return userDataAccessService.deleteUser(userID);
    }


}
