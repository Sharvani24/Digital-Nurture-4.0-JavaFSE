package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
