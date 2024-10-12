package com.example.employeeprojectapp.repository;

import com.example.employeeprojectapp.entity.Interview;
import com.example.employeeprojectapp.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
    List<Interview> findByStatusAndEmployee_Project(String status, Project project);
}