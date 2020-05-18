package com.example.service;


import com.example.controller.LoginController;
import com.example.data.RoleDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService {

    private final RoleDataAccessService roleDataAccessService;
    @Autowired
    private LoginController loginController;


    @Autowired
    public RoleService(RoleDataAccessService roleDataAccessService) {
        this.roleDataAccessService = roleDataAccessService;
    }

}
