package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByNameContainingIgnoreCase(String name);

    // Using @Query
    @Query("SELECT e FROM Employee e WHERE e.email LIKE %?1%")
    List<Employee> searchByEmail(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.department.name = ?1")
    List<Employee> findByDepartmentName(String departmentName);
}
