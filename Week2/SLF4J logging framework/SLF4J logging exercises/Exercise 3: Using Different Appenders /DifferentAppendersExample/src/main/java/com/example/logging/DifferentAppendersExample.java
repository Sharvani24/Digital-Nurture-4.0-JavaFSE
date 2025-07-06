package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DifferentAppendersExample {
    private static final Logger logger = LoggerFactory.getLogger(DifferentAppendersExample.class);

    public static void main(String[] args) {
        logger.info("Logging to console and file - INFO level");
        logger.debug("Logging to console and file - DEBUG level");
        logger.error("Logging to console and file - ERROR level");
    }
}
