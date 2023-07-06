package com.practice.project.controller;

import com.practice.project.Exception.EmployeeNotFoundException;
import com.practice.project.response.EmployeeResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public EmployeeResponse handleEmployeeNotFoundException(EmployeeNotFoundException exception){
        return new EmployeeResponse(exception.getMessage());
    }

}
