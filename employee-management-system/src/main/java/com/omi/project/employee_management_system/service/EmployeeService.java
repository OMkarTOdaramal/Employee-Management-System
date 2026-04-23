package com.omi.project.employee_management_system.service;

import com.omi.project.employee_management_system.dto.EmployeeDto;
import com.omi.project.employee_management_system.entity.Employee;
import com.omi.project.employee_management_system.exceptions.ResourceNotFoundException;
import com.omi.project.employee_management_system.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeDto getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return modelMapper.map(employee,EmployeeDto.class);
    }

}
