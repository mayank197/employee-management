package com.workplace.employee.service;

/*
    File Name : EmployeeService.java
    
    @author Mayank Sharma
    First Created on 27-06-2020 at 14:33
*/

import com.workplace.employeeentity.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepository;

    public List<String> getEmployeeNames() {
        return empRepository.findAll().stream().limit(10).map(emp->(emp.getFirstName() + " " + emp.getLastName()))
                .collect(Collectors.toList());
    }
}
