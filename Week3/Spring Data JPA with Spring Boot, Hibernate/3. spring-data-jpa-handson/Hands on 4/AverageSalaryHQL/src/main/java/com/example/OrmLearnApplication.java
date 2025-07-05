package com.example;

import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        testGetAverageSalary();
        testGetAverageSalaryByDepartment();
    }

    public void testGetAverageSalary() {
        double avgSalary = employeeService.getAverageSalary();
        System.out.println("Average Salary of All Employees: " + avgSalary);
    }

    public void testGetAverageSalaryByDepartment() {
        int deptId = 1; // example department ID
        double avgSalary = employeeService.getAverageSalary(deptId);
        System.out.println("Average Salary in Department " + deptId + ": " + avgSalary);
    }
}
