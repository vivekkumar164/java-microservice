package com.example.employeeService.service.impl;

import com.example.employeeService.dto.ApiResponseDto;
import com.example.employeeService.dto.DepartmentDto;
import com.example.employeeService.dto.EmployeeDto;
import com.example.employeeService.entity.Employee;
import com.example.employeeService.mapper.EmployeeDtoMapper;
import com.example.employeeService.repository.EmployeeRepository;
import com.example.employeeService.service.ApiClient;
import com.example.employeeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    //private RestTemplate restTemplate;
    //private WebClient webClient;
    private ApiClient apiClient;




    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeDtoMapper.toEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeDtoMapper.toEmployeeDto(savedEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream().map((employee)-> EmployeeDtoMapper.toEmployeeDto(employee))
                .collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public ApiResponseDto getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Resourse not found"));

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                                                        DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

//      DepartmentDto departmentDto =  webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()// since we are retriving the data
//                .bodyToMono(DepartmentDto.class)
//                .block(); // to make sure api call is synchronous .block is used

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(EmployeeDtoMapper.toEmployeeDto(employee));
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
