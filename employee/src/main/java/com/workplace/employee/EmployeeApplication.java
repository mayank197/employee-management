package com.workplace.employee;
/*
    File Name : EmployeeApplication.java
    
    @author Mayank Sharma
    First Created on 27-06-2020 at 13:37
*/

import com.workplace.employee.controller.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.workplace.employee","com.workplace.employeeentity"})
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class,args);
    }

}
