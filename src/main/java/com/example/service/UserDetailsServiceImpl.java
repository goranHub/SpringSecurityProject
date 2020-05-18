package com.example.service;

import com.example.model.Role;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDataAccessService userDataRepository;
    @Autowired
    private RoleDataAccessService roleDataAccessService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsManagerImpl userDetailsManager;

    public User user;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        user = userDataRepository.loadUserByUsername(username);
        Role role = roleDataAccessService.getRoleByUserId(user.getId());


        if (role.getUser_id() == 1) {
            user = new User(user.getFname(), passwordEncoder.encode(user.getPassword()), "ADMIN");
            userDetailsManager.updateUser(user);
        }

        if (role.getUser_id() == 2) {
            user = new User(user.getFname(), passwordEncoder.encode(user.getPassword()), "DEVELOPER");
            userDetailsManager.updateUser(user);
        }

        if (role.getUser_id() == 3) {
            user = new User(user.getFname(), passwordEncoder.encode(user.getPassword()), "ANOTHER");
            userDetailsManager.updateUser(user);
        }

        if (role.getUser_id() == 4) {
            user = new User(user.getFname(), passwordEncoder.encode(user.getPassword()), "CUSTOMER");
            userDetailsManager.updateUser(user);
        }

        if (role.getUser_id() == 5) {
            user = new User(user.getFname(), passwordEncoder.encode(user.getPassword()), "OWNER");
            userDetailsManager.updateUser(user);
        }

        return user;

    }
}
