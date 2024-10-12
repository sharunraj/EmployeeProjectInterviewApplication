package com.example.employeeprojectapp.service;

import com.example.employeeprojectapp.dto.EmployeeDto;
import com.example.employeeprojectapp.dto.InterviewDto;
import com.example.employeeprojectapp.dto.ProjectDto;
import com.example.employeeprojectapp.entity.Employee;
import com.example.employeeprojectapp.entity.Interview;
import com.example.employeeprojectapp.entity.Project;
import com.example.employeeprojectapp.repository.EmployeeRepository;
import com.example.employeeprojectapp.repository.InterviewRepository;
import com.example.employeeprojectapp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private InterviewRepository  interviewRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public void addEmployee(EmployeeDto employee) {

        Project project = projectRepository.findById(employee.getProjectId()).orElse(null);
        Employee employee1 = new Employee();
        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());
        employee1.setProject(project);
        employeeRepository.save(employee1);
//        employeeRepository.save(employee);
    }

    public void addInterview(InterviewDto interview) {

        Employee employee = employeeRepository.findById(interview.getEmployeeId()).orElse(null);
        Interview interview1 = new Interview();
        interview1.setEmployee(employee);
        //interviewRepository.save(interview);
    }

    public void addProject(ProjectDto project) {

        Project project1 = new Project();
        project1.setProjectName(project.getProjectName());
        projectRepository.save(project1);


    }

    public List<Employee> getEmployeesByProject(Project  project) {
        return employeeRepository.findByProject(project);
    }

    public List<Employee> getEmployeesFailedInterviewByProject(Project project){
        return interviewRepository.findByStatusAndEmployee_Project("failed", project)
                .stream()
                .map(Interview::getEmployee)
                .collect(Collectors.toList());
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }
}
