package com.example;

import com.example.model.Attempt;
import com.example.model.AttemptQuestion;
import com.example.model.AttemptOption;
import com.example.service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        testGetAttemptDetail();
    }

    public void testGetAttemptDetail() {
        Attempt attempt = attemptService.getAttempt(1, 1);
        System.out.println("Username: " + attempt.getUser().getUsername());
        System.out.println("Attempted Date: " + attempt.getAttemptedDate());

        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
            System.out.println(aq.getQuestion().getText());
            for (AttemptOption ao : aq.getAttemptOptions()) {
                System.out.println(" " + ao.getOption().getText() + "	" +
                        ao.getOption().getScore() + "	" + ao.isSelected());
            }
        }
    }
}
