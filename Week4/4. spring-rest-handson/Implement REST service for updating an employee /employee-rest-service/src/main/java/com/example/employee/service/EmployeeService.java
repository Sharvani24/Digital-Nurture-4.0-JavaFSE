package com.example.employee.service;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao dao;

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        dao.updateEmployee(employee);
    }
}