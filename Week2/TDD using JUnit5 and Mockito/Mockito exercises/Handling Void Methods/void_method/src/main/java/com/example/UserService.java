package com.example;

public class UserService {
    private Logger logger;

    public UserService(Logger logger) {
        this.logger = logger;
    }

    public void registerUser(String username) {
        // Simulate registration
        logger.log("User registered: " + username);
    }
}
