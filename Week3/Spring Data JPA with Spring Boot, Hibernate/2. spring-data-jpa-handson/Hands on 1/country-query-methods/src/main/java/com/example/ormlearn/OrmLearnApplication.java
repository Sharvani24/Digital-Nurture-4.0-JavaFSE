package com.example.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testFindByNameContaining();
        testFindByNameContainingOrderByNameAsc();
        testFindByNameStartingWith();
    }

    private void testFindByNameContaining() {
        List<Country> countries = countryRepository.findByNameContaining("ou");
        countries.forEach(System.out::println);
    }

    private void testFindByNameContainingOrderByNameAsc() {
        List<Country> countries = countryRepository.findByNameContainingOrderByNameAsc("ou");
        countries.forEach(System.out::println);
    }

    private void testFindByNameStartingWith() {
        List<Country> countries = countryRepository.findByNameStartingWith("Z");
        countries.forEach(System.out::println);
    }
}
