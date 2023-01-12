package com.example.animalshelter.security;

import com.example.animalshelter.employee.EmployeeService;
import com.example.animalshelter.employee.EmployeeDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomInMemoryUserDetailsManager implements UserDetailsManager {

    private EmployeeService employeeService;

    public CustomInMemoryUserDetailsManager(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeService.findEmployeeByUserNameDTO(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("nie znaleziono użytkownika o nazwie "+ username));

    }

    private UserDetails createUserDetails(EmployeeDTO employeeDTO){
        return new User(employeeDTO.getUserName(), employeeDTO.getPassword(), convertAuthority(employeeDTO.getRoles()));


    }

    private List<GrantedAuthority> convertAuthority(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }
}
