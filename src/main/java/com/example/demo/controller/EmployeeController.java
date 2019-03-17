package com.example.demo.controller;

import com.example.demo.service.EmployeeService;
import com.example.demo.entity.Employee;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeController {


    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = {"/employee/{id}"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getEmployee(@PathVariable int id){
        Employee employee = employeeService.findEmployeeBy(id);

        return ResponseEntity.ok(employee);

    }

}
