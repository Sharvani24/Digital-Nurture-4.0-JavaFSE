package com.example.employee.dao;

import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {
    private static List<Employee> employeeList = new ArrayList<>();

    public void updateEmployee(Employee emp) throws EmployeeNotFoundException {
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(emp.getId())) {
                employeeList.set(i, emp);
                found = true;
                break;
            }
        }
        if (!found) throw new EmployeeNotFoundException("Employee not found");
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}