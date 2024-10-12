package com.example.employeeprojectapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private String name;
    private String email;
    private Long projectId; // ID of the project the employee will be assigned to

    // Getters and setters
}