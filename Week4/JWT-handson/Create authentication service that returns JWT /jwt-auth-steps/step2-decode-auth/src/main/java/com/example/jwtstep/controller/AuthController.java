package com.example.jwtstep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@RestController
public class AuthController {

    @GetMapping("/authenticate")
    public String authenticate(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Basic ")) {
            return "Missing or invalid Authorization header";
        }
        String[] credentials = new String(Base64.getDecoder().decode(header.substring(6))).split(":");
        String username = credentials[0];
        String password = credentials[1];

        return "Username: " + username + ", Password: " + password;
    }
}