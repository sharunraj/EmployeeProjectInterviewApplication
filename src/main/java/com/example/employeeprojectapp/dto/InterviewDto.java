package com.example.employeeprojectapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewDto {
    private Long employeeId; // ID of the employee who had the interview
    private String status;
}
