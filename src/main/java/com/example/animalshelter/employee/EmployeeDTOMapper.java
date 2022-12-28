package com.example.animalshelter.employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeDTOMapper {

    public EmployeeDTO toDTO(Employee employee){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setUserName(employee.getUserName());
        dto.setPassword(employee.getPassword());
        dto.setRoles(employee.getRoles());
        return dto;
    }
}
