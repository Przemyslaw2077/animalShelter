package com.example.animalshelter;


import com.example.animalshelter.employee.Employee;
import com.example.animalshelter.employee.EmployeeDTO;
import com.example.animalshelter.employee.EmployeeDTOMapper;
import com.example.animalshelter.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private EmployeeDTOMapper employeeDTOMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeDTOMapper employeeDTOMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeDTOMapper = employeeDTOMapper;
    }

    public Optional<EmployeeDTO> findEmployeeByUserNameDTO(String userName){
        Optional<Employee> byUserName = employeeRepository.findByUserName(userName);

        return byUserName.map(employeeDTOMapper::toDTO);
    }

    public Optional<Employee> findEmployeeByUserName(String userName){
        Optional<Employee> byUserName = employeeRepository.findByUserName(userName);

        return byUserName;
    }

    List<EmployeeDTO> findAll(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees.stream().map(employeeDTOMapper::toDTO).toList();
    }


}
