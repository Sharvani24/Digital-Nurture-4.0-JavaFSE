package com.example.dao;

import com.example.model.Department;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    private static List<Department> DEPARTMENT_LIST;

    public DepartmentDao(ApplicationContext context) {
        DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList");
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}