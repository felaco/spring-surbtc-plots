package org.facosta.springsurbtcplots.services;

import org.facosta.springsurbtcplots.models.entity.Role;
import org.facosta.springsurbtcplots.models.entity.UserModel;
import org.facosta.springsurbtcplots.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("CustomUserDetailsService")
public class UserDetailServiceImp implements UserDetailsService
{
    private UserRepository userRepository;

    @Autowired
    public UserDetailServiceImp(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserModel userModel = userRepository.findByUsername(username);

        if (userModel == null)
            throw new UsernameNotFoundException("Username: " + username + " not found!");

        List<GrantedAuthority> roles = new ArrayList<>();
        for (Role role: userModel.getRoles())
        {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }

        return User.withUsername(userModel.getUsername())
                   .authorities(roles)
                   .password(userModel.getPassword())
                   .build();
    }
}
