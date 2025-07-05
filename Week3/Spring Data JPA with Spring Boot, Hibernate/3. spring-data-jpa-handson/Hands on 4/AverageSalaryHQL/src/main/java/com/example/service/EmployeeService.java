package com.example.service;

import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public double getAverageSalary() {
        return employeeRepository.getAverageSalary();
    }

    public double getAverageSalary(int deptId) {
        return employeeRepository.getAverageSalary(deptId);
    }
}
