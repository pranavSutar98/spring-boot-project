package com.practice.project.service.impl;

import com.practice.project.Exception.EmployeeNotFoundException;
import com.practice.project.dto.EmployeeDTO;
import com.practice.project.entity.Employee;
import com.practice.project.repository.EmployeeRepository;
import com.practice.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Integer empId) {
        Optional<Employee> employee = repository.findById(empId);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new EmployeeNotFoundException("Employee not found with Employee_Id : " + empId);
        }
    }

    @Override
    public Employee updateEmployee(EmployeeDTO empDto, Integer empId) {
        Optional<Employee> employee = repository.findById(empId);
        Employee employee1 = null;
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found with Employee_Id : " + empId);
        } else {
            employee.get().setFirstName(empDto.getFirstName()!=null ? empDto.getFirstName() : employee.get().getFirstName());
            employee.get().setLastName(empDto.getLastName()!=null ? empDto.getLastName() : employee.get().getLastName());
            employee.get().setAge(empDto.getAge()!=null ? empDto.getAge() : employee.get().getAge());
            employee1 = repository.save(employee.get());
        }
        return employee1;
    }

    @Override
    public String deleteEmployee(Integer empId) {
        Optional<Employee> employee = repository.findById(empId);
        if(employee.isPresent()) {
            repository.deleteById(empId);
            return "Employee Record Deleted Successfully";
        }
        else {
            throw new EmployeeNotFoundException("Employee not found with Employee_Id : "+ empId);
        }
    }


}
