package com.example;

public class ErrorHandler {
    private ExceptionLogger logger;

    public ErrorHandler(ExceptionLogger logger) {
        this.logger = logger;
    }

    public void handleError(String error) {
        logger.logError(error);
    }
}
