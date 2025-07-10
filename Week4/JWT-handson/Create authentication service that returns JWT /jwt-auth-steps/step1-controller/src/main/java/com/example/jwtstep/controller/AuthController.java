package com.example.jwtstep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/authenticate")
    public String authenticate() {
        return "Authentication endpoint initialized.";
    }
}