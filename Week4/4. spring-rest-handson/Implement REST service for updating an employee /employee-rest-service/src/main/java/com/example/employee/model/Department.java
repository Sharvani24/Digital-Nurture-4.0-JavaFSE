package com.example.employee.model;

import jakarta.validation.constraints.*;

public class Department {
    @NotNull
    private Long id;

    @NotBlank
    @Size(min = 1, max = 30)
    private String name;

    // Getters and Setters
}