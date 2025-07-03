package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void displayBooks() {
        System.out.println("Displaying all books in the repository...");
    }
}
