package com.example.ormlearn;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByNameContaining(String keyword);
    List<Country> findByNameContainingOrderByNameAsc(String keyword);
    List<Country> findByNameStartingWith(String prefix);
}
