package com.example.departmentService.service.impl;

import com.example.departmentService.dto.DepartmentDto;
import com.example.departmentService.entity.Department;
import com.example.departmentService.mapper.DepartmentMapperDto;
import com.example.departmentService.repository.DepartmentRepository;
import com.example.departmentService.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapperDto.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapperDto.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        DepartmentDto departmentDto = DepartmentMapperDto.mapToDepartmentDto(department);
        return departmentDto;
    }
}
