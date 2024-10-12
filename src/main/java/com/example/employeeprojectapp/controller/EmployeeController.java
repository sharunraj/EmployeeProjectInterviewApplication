package com.example.employeeprojectapp.controller;

import com.example.employeeprojectapp.dto.EmployeeDto;
import com.example.employeeprojectapp.dto.InterviewDto;
import com.example.employeeprojectapp.dto.ProjectDto;
import com.example.employeeprojectapp.entity.Employee;
import com.example.employeeprojectapp.entity.Interview;
import com.example.employeeprojectapp.entity.Project;
import com.example.employeeprojectapp.repository.InterviewRepository;
import com.example.employeeprojectapp.repository.ProjectRepository;
import com.example.employeeprojectapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/add/employee")
    public void addEmployee(@RequestBody EmployeeDto employee) {

        employeeService.addEmployee(employee);
    }

    @PostMapping("/add/project")
    public void addProject(@RequestBody ProjectDto project) {
        employeeService.addProject(project);
    }

    @PostMapping("/add/interview")
    public void addInterview(@RequestBody InterviewDto interview) {

        employeeService.addInterview(interview);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Employee>> getEmployeesByProject(@PathVariable Long projectId) {
        Project project = employeeService.getProjectById(projectId);
        List<Employee> employees = employeeService.getEmployeesByProject(project);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/project/failed/{projectId}")
    public ResponseEntity<List<Employee>> getFailedEmployeesByProject(@PathVariable Long projectId) {
        Project project = employeeService.getProjectById(projectId);
        List<Employee> failedEmployees = employeeService.getEmployeesFailedInterviewByProject(project);
        return ResponseEntity.ok(failedEmployees);
    }
}
