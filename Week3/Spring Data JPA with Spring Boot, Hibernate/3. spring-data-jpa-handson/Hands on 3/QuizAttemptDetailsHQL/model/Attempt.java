package com.example.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Attempt {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Date attemptedDate;

    @OneToMany(mappedBy = "attempt")
    private List<AttemptQuestion> attemptQuestions;

    // Getters and setters
}
