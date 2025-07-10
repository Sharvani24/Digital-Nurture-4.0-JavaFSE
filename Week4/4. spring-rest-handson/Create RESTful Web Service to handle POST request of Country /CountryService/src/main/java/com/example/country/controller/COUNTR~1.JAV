package com.example.country.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    Logger logger = LoggerFactory.getLogger(CountryController.class);

    @PostMapping("/countries")
    public void addCountry() {
        logger.info("Start");
    }
}
