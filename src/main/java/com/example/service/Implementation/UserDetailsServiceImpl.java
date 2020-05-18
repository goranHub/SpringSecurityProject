package com.example.service.Implementation;

import com.example.data.RoleDataAccessService;
import com.example.data.UserDataAccessService;
import com.example.model.Role;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDataAccessService userDataRepository;
    @Autowired
    private RoleDataAccessService roleDataAccessService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsManagerImpl userDetailsManager;
    @Autowired
    User user;
    @Autowired
    Role role;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        user = userDataRepository.loadUserByUsername(username);


        if (user.getFname().equals("admin") && user.getPassword().equals("admin")) {

            user = new User(user.getFname(), passwordEncoder.encode(user.getPassword()), "ADMIN");
            user.setId(user.getId() +1);
            role.setUser_id(user.getId());
            role.setId(role.getId()+1);
            userDetailsManager.createUser(user);
            roleDataAccessService.setRoleAdmin(role,user);
            return user;
        }

        if (user.getFname().equals("develop") && user.getPassword().equals("develop")) {
            user = new User(user.getFname(), passwordEncoder.encode(user.getPassword()), "DEVELOPER");
            user = new User(user.getFname(), passwordEncoder.encode(user.getPassword()), "ADMIN");
            user.setId(user.getId() +1);
            role.setUser_id(user.getId());
            role.setId(role.getId()+1);
            userDetailsManager.createUser(user);
            roleDataAccessService.setRoleDeveloper(role, user);

            return user;
        }

        return null;
    }


}



