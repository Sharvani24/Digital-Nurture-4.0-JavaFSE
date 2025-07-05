package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = 1")
    List<Employee> getAllPermanentEmployees();
}
