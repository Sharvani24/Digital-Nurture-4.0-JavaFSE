package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.dto.EmployeeDTO;
import com.example.employeemanagementsystem.projection.EmployeeNameEmailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByNameContainingIgnoreCase(String name);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %?1%")
    List<Employee> searchByEmail(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.department.name = ?1")
    List<Employee> findByDepartmentName(String departmentName);

    // Interface-based projection
    List<EmployeeNameEmailProjection> findByNameStartingWith(String prefix);

    // DTO-based projection using constructor expression
    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.name, e.department.name) FROM Employee e")
    List<EmployeeDTO> fetchEmployeeDTOs();
}
