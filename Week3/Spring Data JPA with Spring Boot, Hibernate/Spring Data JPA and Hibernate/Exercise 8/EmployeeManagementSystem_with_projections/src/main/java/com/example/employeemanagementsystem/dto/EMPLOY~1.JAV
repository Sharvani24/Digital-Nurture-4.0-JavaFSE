package com.example.employeemanagementsystem.dto;

public class EmployeeDTO {
    private String name;
    private String departmentName;

    public EmployeeDTO(String name, String departmentName) {
        this.name = name;
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
