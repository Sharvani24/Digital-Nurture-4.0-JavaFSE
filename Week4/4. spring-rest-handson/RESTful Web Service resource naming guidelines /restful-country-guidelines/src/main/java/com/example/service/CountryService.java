package com.example.service;

import com.example.model.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private static List<Country> countries = new ArrayList<>();

    public List<Country> getAllCountries() {
        return countries;
    }

    public Country getCountry(String code) {
        return countries.stream().filter(c -> c.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }

    public Country createCountry(Country country) {
        countries.add(country);
        return country;
    }

    public Country updateCountry(Country country) {
        deleteCountry(country.getCode());
        countries.add(country);
        return country;
    }

    public String deleteCountry(String code) {
        countries.removeIf(c -> c.getCode().equalsIgnoreCase(code));
        return "Deleted " + code;
    }
}