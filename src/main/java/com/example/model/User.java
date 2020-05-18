package com.example.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class User implements UserDetails, Serializable {




    private int id;
    private String login;
    private String password;
    private String fname;
    private String lname;
    private String email;
    private UserDetails usserdetails;
    String role;
    private int active;
    String ROLE_PREFIX = "ROLE_";

    public User() {
        super();
    }
    public User(String subject, String password, Collection<? extends GrantedAuthority> authorities) {
        super();
    }

    public User(int id, String login, String password, String fname, String lname, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public User(String username, String password, String role){
        this.fname = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, String password){
        this.fname = username;
        this.password = password;
    }

/*
    public User(UserDetails usserdetails) {
        this.usserdetails = usserdetails;
    }
*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
        return list;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getFname();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getFname() {
        return fname;
    }


    public String getLname() {
        return lname;
    }


    public String getEmail() {
        return email;
    }


    public int getActive() {
        return 1;
    }


    public void setRole(String role) {
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }

}