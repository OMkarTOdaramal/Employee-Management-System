package com.omi.project.employee_management_system.service;

import com.omi.project.employee_management_system.dto.EmployeeDto;
import com.omi.project.employee_management_system.entity.Employee;
import com.omi.project.employee_management_system.exceptions.ResourceNotFoundException;
import com.omi.project.employee_management_system.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
         Employee newEmployee = modelMapper.map(employeeDto,Employee.class);
         Employee savedEmployee = employeeRepository.save(newEmployee);
         return modelMapper.map(savedEmployee,EmployeeDto.class);
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        modelMapper.map(employeeDto, employee);

        employee.setId(id); // enforce identity

        Employee updatedEmployee = employeeRepository.save(employee);
        return modelMapper.map(updatedEmployee, EmployeeDto.class);
    }

    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(emp -> modelMapper.map(emp, EmployeeDto.class))
                .toList();
    }

    public void deleteEmployee(Long id) {
        if(!employeeRepository.existsById(id)){
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
