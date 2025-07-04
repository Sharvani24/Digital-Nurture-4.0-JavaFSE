package com.example.country;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public Country addCountry(Country country) {
        return repository.save(country);
    }

    public Country updateCountry(Country country) {
        return repository.save(country);
    }

    public void deleteCountry(String code) {
        repository.deleteById(code);
    }

    public Optional<Country> findByCode(String code) {
        return repository.findById(code);
    }

    public List<Country> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
