package com.cognizant.spring_learn;

import com.cognizant.spring_learn.controller.CountryController;
import com.cognizant.spring_learn.service.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CountryController.class)
public class SpringLearnApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @Test
    public void testGetCountryException() throws Exception {
        String countryCode = "XX";

        when(countryService.getCountry(countryCode))
                .thenThrow(new CountryNotFoundException("Country Not found"));

        mockMvc.perform(get("/countries/" + countryCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(status().reason("Country Not found"));
    }
}