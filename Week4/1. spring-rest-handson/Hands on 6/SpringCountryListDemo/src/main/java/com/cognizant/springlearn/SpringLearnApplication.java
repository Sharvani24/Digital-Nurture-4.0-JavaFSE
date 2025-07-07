package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        displayCountries();
    }

    public static void displayCountries() {
        LOGGER.debug("START displayCountries()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country-list.xml");
        List<Country> countryList = context.getBean("countryList", List.class);
        for (Country country : countryList) {
            LOGGER.debug("Country : {}", country.toString());
        }
        LOGGER.debug("END displayCountries()");
    }
}
