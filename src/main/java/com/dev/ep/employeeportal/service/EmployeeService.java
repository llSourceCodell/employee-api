package com.dev.ep.employeeportal.service;

import com.dev.ep.employeeportal.exception.ResourceNotFoundException;
import com.dev.ep.employeeportal.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Long employeeId) throws ResourceNotFoundException;
    Employee save(Employee employee);
    void delete(Employee employee);
}
