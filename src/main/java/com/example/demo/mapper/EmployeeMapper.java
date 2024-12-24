package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {
    public final ModelMapper modelMapper ;
    public EmployeeDto mapToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = modelMapper.map (employee, EmployeeDto.class);
        return employeeDto;
    }

    public  Employee mapToEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map (employeeDto, Employee.class);
        return employee;
    }
    public Employee updateEmployee(Employee employee, EmployeeDto employeeDto) {

        if (employeeDto.getFirstName () != null)
            employee.setFirstName(employeeDto.getFirstName ());
        if(employeeDto.getLastName()!=null)
            employee.setLastName(employeeDto.getLastName());
        if(employeeDto.getEmailId()!=null)
            employee.setEmailId(employeeDto.getEmailId());
        return employee;
    }

}
