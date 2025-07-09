package com.example.dao;

import com.example.model.Employee;
import org.springframework.context.ApplicationContext;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static List<Employee> EMPLOYEE_LIST;

    public EmployeeDao(ApplicationContext context) {
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}