package com.example.animalshelter.employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    public Optional<Employee> findByUserName(String userName);
}
