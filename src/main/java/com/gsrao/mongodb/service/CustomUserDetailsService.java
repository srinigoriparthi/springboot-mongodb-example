package com.gsrao.mongodb.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Replace this with your logic to fetch user details from a database
        if ("admin".equals(username)) {
            return new User("admin", "{noop}admin123", Collections.emptyList());
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}