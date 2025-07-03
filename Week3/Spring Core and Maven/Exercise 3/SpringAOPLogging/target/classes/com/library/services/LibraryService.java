package com.library.service;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    public void manageBooks() {
        System.out.println("Managing books in the library...");
        try { Thread.sleep(500); } catch (InterruptedException e) { }
    }
}
