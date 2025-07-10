package com.example.employee;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.employee.exception.EmployeeNotFoundException;

@WebMvcTest
public class EmployeeControllerDeleteTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void deleteNonExistentEmployee_ShouldReturnNotFound() throws Exception {
        doThrow(new EmployeeNotFoundException("Employee not found")).when(employeeService).deleteEmployee(100L);

        mockMvc.perform(delete("/employees/100"))
                .andExpect(status().isNotFound());
    }
}