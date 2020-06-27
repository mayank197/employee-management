package com.workplace.employee.controller;

/*
    File Name : EmployeeController.java
    
    @author Mayank Sharma
    First Created on 27-06-2020 at 14:33
*/

import com.workplace.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @GetMapping(value = "/names")
    public List<String> getAllEmployees(){
        return empService.getEmployeeNames();
    }

}
