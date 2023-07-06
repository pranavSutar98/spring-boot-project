package com.practice.project.service;

import com.practice.project.dto.EmployeeDTO;
import com.practice.project.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> findAll();

    Employee findById(Integer empId);

    Employee updateEmployee(EmployeeDTO empDto, Integer empId);

    String deleteEmployee(Integer empId);

}
