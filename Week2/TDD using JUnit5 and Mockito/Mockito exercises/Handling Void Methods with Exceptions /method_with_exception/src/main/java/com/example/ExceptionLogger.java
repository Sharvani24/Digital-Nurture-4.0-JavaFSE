package com.example;

public interface ExceptionLogger {
    void logError(String error) throws RuntimeException;
}
