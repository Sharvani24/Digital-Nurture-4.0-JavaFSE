package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.debug("Demonstrating Singleton Scope");
        displayCountrySingleton();

        LOGGER.debug("Demonstrating Prototype Scope");
        displayCountryPrototype();
    }

    public static void displayCountrySingleton() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Country 1 : {}", country.toString());
        LOGGER.debug("Country 2 : {}", anotherCountry.toString());
    }

    public static void displayCountryPrototype() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country-prototype.xml");
        Country country = context.getBean("country", Country.class);
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Country 1 : {}", country.toString());
        LOGGER.debug("Country 2 : {}", anotherCountry.toString());
    }
}
