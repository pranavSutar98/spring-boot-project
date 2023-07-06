package com.practice.project.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeNotFoundException extends RuntimeException {

    private String message;

    public EmployeeNotFoundException(String message) {
        super(message);
        this.message=message;
    }

    public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
