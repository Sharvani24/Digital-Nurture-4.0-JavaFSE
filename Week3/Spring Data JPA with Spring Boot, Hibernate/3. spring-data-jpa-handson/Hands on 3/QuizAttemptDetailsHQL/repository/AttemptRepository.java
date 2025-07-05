package com.example.repository;

import com.example.model.Attempt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AttemptRepository extends CrudRepository<Attempt, Integer> {
    @Query("SELECT a FROM Attempt a "
         + "JOIN FETCH a.user u "
         + "JOIN FETCH a.attemptQuestions aq "
         + "JOIN FETCH aq.question q "
         + "JOIN FETCH aq.attemptOptions ao "
         + "JOIN FETCH ao.option o "
         + "WHERE u.id = ?1 AND a.id = ?2")
    Attempt getAttempt(int userId, int attemptId);
}
