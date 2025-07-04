
package com.example.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ormlearn.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
