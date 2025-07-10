
/*
 * File: CountryController.java
 * Description: Uses @Valid for automatic validation and relies on global exception handler.
 */

package com.example.demo.controller;

import com.example.demo.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @PostMapping("/countries")
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("Country Received - Code: {}, Name: {}", country.getCode(), country.getName());
        return country;
    }
}
