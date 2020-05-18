package com.example.data.Implementation;


import com.example.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("userDetailsManager")
public class UserDetailsManagerImpl implements UserDetailsManager {


    public List<UserDetails> users = new ArrayList<>();
    public List<User> usersAusUSer = new ArrayList<>();


    @Override
    public void createUser(UserDetails userDetails) {
        users.add(userDetails);
    }

    @Override
    public void updateUser(UserDetails userDetails) {
    }

    @Override
    public void deleteUser(String s) {
    }

    @Override
    public void changePassword(String s, String s1) {
    }

    @Override
    public boolean userExists(String username) {
      //  User userNull new  User();
        // createUser(userNull);
        return users.stream()
                .anyMatch(user -> user.getUsername().equals(username));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return users.stream()
                .filter(user -> user.getUsername().equals(s))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("not find"));
    }


    public User loadUserByUsernameReturnUser(String s) throws UsernameNotFoundException {
        return  usersAusUSer.stream()
                .filter(user -> user.getUsername().equals(s))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("not find"));

    }

}
