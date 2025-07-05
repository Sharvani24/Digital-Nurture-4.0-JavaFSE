package com.example;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        testGetAllEmployeesNative();
    }

    public void testGetAllEmployeesNative() {
        List<Employee> employees = employeeService.getAllEmployeesNative();
        employees.forEach(e -> System.out.println("ID: " + e.getId() +
                ", Name: " + e.getName() +
                ", Salary: " + e.getSalary()));
    }
}
