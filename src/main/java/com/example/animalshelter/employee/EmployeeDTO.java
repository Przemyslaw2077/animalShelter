package com.example.animalshelter.employee;

import com.example.animalshelter.security.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private List<UserRole> roles;



    public EmployeeDTO() {
    }
}
