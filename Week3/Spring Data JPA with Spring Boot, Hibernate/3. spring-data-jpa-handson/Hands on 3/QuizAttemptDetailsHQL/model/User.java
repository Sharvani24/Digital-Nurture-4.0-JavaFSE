package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    private int id;
    private String username;

    @OneToMany(mappedBy = "user")
    private List<Attempt> attempts;

    // Getters and setters
}
