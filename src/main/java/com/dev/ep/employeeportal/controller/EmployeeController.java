package com.dev.ep.employeeportal.controller;

import com.dev.ep.employeeportal.exception.ResourceNotFoundException;
import com.dev.ep.employeeportal.model.Employee;
import com.dev.ep.employeeportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeService.findById(employeeId);
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable (value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeService.findById(employeeId);
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setDesignation(employeeDetails.getDesignation());
        employee.setLocation(employeeDetails.getLocation());
        final Employee updatedEmployee = employeeService.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable (value = "id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeService.findById(employeeId);
        employeeService.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
