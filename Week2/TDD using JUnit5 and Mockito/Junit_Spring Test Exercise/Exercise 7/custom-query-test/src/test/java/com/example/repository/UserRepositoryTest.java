package com.example.repository;

import com.example.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        User user1 = new User(1L, "Alice");
        User user2 = new User(2L, "Alice");
        User user3 = new User(3L, "Bob");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        List<User> foundUsers = userRepository.findByName("Alice");
        Assertions.assertEquals(2, foundUsers.size());
    }
}