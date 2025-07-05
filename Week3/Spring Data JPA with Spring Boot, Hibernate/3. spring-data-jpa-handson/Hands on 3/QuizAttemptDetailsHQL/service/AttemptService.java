package com.example.service;

import com.example.model.Attempt;
import com.example.repository.AttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptService {
    @Autowired
    private AttemptRepository attemptRepository;

    public Attempt getAttempt(int userId, int attemptId) {
        return attemptRepository.getAttempt(userId, attemptId);
    }
}
