package com.example.model;

import javax.persistence.*;

@Entity
public class Option {
    @Id
    private int id;
    private String text;
    private double score;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // Getters and setters
}
