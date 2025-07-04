
package com.example.demo;

import com.example.demo.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrmLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ApplicationContext context) {
        return args -> {
            CountryService countryService = context.getBean(CountryService.class);
            countryService.updateCountry("IN", "Bharat");
            System.out.println("Country updated successfully.");
        };
    }
}
