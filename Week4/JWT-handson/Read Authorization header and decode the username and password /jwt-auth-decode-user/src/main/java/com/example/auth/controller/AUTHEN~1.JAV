package com.example.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        logger.info("Start authentication");
        logger.debug("Authorization Header: {}", authHeader);

        String user = getUser(authHeader);
        logger.debug("Extracted Username: {}", user);

        Map<String, String> map = new HashMap<>();
        map.put("token", "");

        logger.info("End authentication");
        return map;
    }

    private String getUser(String authHeader) {
        logger.debug("Decoding Authorization header");
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes);
        logger.debug("Decoded String: {}", decodedString);
        String username = decodedString.split(":")[0];
        return username;
    }
}