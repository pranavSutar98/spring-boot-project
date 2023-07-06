package com.practice.project.controller;

import com.practice.project.dto.EmployeeDTO;
import com.practice.project.entity.Employee;
import com.practice.project.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/find/{empId}")
    public Employee findEmployeeById(@PathVariable("empId") Integer empId) {
        return employeeService.findById(empId);
    }

    @PutMapping("/update/{empId}")
    public Employee updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable("empId") Integer empId) {
        return employeeService.updateEmployee(employeeDTO, empId);
    }

    @DeleteMapping("/delete/{empId}")
    public String deleteEmployee(@PathVariable("empId") Integer empId)
    {
        return employeeService.deleteEmployee(empId);
    }

}
