package com.example.model;

import javax.persistence.*;

@Entity
public class AttemptOption {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "attempt_question_id")
    private AttemptQuestion attemptQuestion;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option;

    private boolean selected;

    // Getters and setters
}
