package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.model.Employee;

@RestController
@CrossOrigin
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private ApplicationContext context;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return (List<Employee>) context.getBean("employeeList");
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        List<Employee> employees = (List<Employee>) context.getBean("employeeList");
        return employees.stream().filter(emp -> emp.getId() == id).findFirst().orElse(null);
    }
}