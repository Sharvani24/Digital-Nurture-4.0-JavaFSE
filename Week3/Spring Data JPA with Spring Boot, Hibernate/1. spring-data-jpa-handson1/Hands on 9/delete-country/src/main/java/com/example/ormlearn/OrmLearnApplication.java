
package com.example.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        testDeleteCountry();
    }

    private static void testDeleteCountry() {
        String code = "ZZ"; // use the same code as added in previous test
        countryService.deleteCountry(code);
        System.out.println("Deleted country with code: " + code);
    }
}
