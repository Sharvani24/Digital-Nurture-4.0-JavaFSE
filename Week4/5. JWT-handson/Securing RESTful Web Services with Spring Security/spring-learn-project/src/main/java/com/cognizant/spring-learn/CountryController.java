package com.cognizant.spring-learn.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return Arrays.asList(
            new Country("US", "United States"),
            new Country("DE", "Germany"),
            new Country("IN", "India"),
            new Country("JP", "Japan")
        );
    }

    static class Country {
        private String code;
        private String name;

        public Country(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() { return code; }
        public String getName() { return name; }
    }
}
