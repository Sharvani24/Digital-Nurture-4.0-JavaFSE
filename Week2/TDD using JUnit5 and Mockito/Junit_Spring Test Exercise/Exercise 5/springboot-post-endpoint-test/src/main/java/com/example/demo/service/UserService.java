package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User saveUser(User user) {
        // Simulate saving user and returning it (e.g., with generated ID)
        user.setId(1L);
        return user;
    }
}