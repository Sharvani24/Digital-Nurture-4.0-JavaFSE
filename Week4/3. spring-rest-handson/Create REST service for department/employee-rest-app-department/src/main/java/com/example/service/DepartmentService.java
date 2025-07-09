package com.example.service;

import com.example.dao.DepartmentDao;
import com.example.model.Department;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Transactional
    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}