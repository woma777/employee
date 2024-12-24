package com.example.demo.service.impl;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    public final EmployeeMapper employeeMapper;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        if (employeeRepository.existsByEmailId(employeeDto.getEmailId())) {
            throw new ResourceExistsException("Employee with EmailId " + employeeDto.getEmailId() + " already exists");
        }


        Employee holiday = employeeMapper.mapToEmployee (employeeDto);
        holiday = employeeRepository.save (holiday);

        return employeeMapper.mapToEmployeeDto (holiday);
    }


    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee holiday = employeeRepository.findById (id)
                .orElseThrow (() -> new ResourceNotFoundException(
                        "Address doesn't exist with given id:" + id));

        return employeeMapper.mapToEmployeeDto (holiday);
    }
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> Holidays = employeeRepository.findAll ();

        return Holidays.stream ()
                .map ((employeeMapper::mapToEmployeeDto))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee address = employeeRepository.findById (id )
                .orElseThrow (() -> new ResourceNotFoundException (
                        "Address doesn't exist with given id:" + id));
        address = employeeMapper.updateEmployee (address, employeeDto);
        address = employeeRepository.save (address);

        return employeeMapper.mapToEmployeeDto (address);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee address = employeeRepository.findById (id )
                .orElseThrow (() -> new ResourceNotFoundException (
                        "Address doesn't exist with given id:" + id));

        employeeRepository.delete (address);
    }


}
