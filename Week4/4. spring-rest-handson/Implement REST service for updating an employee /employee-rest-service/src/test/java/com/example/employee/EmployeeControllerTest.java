package com.example.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testInvalidFormatShouldReturnBadRequest() throws Exception {
        String invalidJson = "{ "id": "abc", "name": "John", "salary": 5000, "permanent": true, "dateOfBirth": "10/10/1990", "department": {"id": 1, "name": "HR"}, "skills": [] }";

        mockMvc.perform(put("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Incorrect format for field 'id'"));
    }
}