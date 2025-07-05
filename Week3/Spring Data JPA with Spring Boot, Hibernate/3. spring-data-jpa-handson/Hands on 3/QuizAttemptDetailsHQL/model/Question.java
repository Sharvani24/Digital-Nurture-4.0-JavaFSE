package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    private int id;
    private String text;

    @OneToMany(mappedBy = "question")
    private List<Option> options;

    // Getters and setters
}
