package com.example.employeeService.service;

import com.example.employeeService.dto.ApiResponseDto;
import com.example.employeeService.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService  {
    EmployeeDto addEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();
    ApiResponseDto getEmployeeById(long id);
}
