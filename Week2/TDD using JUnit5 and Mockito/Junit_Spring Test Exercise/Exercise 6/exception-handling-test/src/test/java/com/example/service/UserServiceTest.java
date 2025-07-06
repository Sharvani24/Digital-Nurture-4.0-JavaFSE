package com.example.service;

import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testGetUserById_UserNotFound() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(1L)).thenReturn(Optional.empty());

        UserService userService = new UserService();
        userService = Mockito.spy(userService);
        Mockito.doReturn(mockRepo).when(userService).getUserRepository();

        assertThrows(UserNotFoundException.class, () -> {
            userService.getUserById(1L);
        });
    }
}