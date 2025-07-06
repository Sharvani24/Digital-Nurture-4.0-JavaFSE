package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String user = "Alice";
        int age = 30;

        logger.info("User {} has logged in.", user);
        logger.debug("User {} is {} years old.", user, age);
        logger.warn("User {} attempted an action without permission.", user);
        logger.error("An error occurred for user {} at age {}", user, age);
    }
}
