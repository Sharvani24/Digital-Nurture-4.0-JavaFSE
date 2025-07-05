package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class AttemptQuestion {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "attempt_id")
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion")
    private List<AttemptOption> attemptOptions;

    // Getters and setters
}
