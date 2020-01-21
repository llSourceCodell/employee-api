package com.dev.ep.employeeportal.service;

import com.dev.ep.employeeportal.exception.ResourceNotFoundException;
import com.dev.ep.employeeportal.model.Employee;
import com.dev.ep.employeeportal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long employeeId) throws ResourceNotFoundException {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}
