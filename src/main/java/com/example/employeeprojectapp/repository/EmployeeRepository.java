package com.example.employeeprojectapp.repository;

import com.example.employeeprojectapp.entity.Employee;
import com.example.employeeprojectapp.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    List<Employee> findByProject(Project project);
}
