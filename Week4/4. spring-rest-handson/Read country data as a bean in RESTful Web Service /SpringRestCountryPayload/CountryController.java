
/*
 * File: CountryController.java
 * Description: Demonstrates reading Country data from request payload in Spring Boot RESTful web service.
 */

package com.example.demo.controller;

import com.example.demo.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        LOGGER.info("Country Received - Code: {}, Name: {}", country.getCode(), country.getName());
        return country;
    }
}
