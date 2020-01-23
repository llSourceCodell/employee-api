package com.dev.ep.employeeportal.controller;

import com.dev.ep.employeeportal.exception.ResourceNotFoundException;
import com.dev.ep.employeeportal.model.Employee;
import com.dev.ep.employeeportal.model.dto.EmployeeCreationDTO;
import com.dev.ep.employeeportal.model.dto.EmployeeDTO;
import com.dev.ep.employeeportal.model.dto.EmployeeUpdateDTO;
import com.dev.ep.employeeportal.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeService.findAll();
        return employees.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        EmployeeDTO employeeDTO = convertToDto(employeeService.findById(employeeId));
        return ResponseEntity.ok().body(employeeDTO);
    }

    @PostMapping("/employees")
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeCreationDTO employeeCreationDTO) {
        Employee employee = modelMapper.map(employeeCreationDTO, Employee.class);
        Employee employeeCreated = employeeService.save(employee);
        return convertToDto(employeeCreated);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                      @Valid @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        Employee employee = modelMapper.map(employeeUpdateDTO, Employee.class);
        final EmployeeDTO updatedEmployee = convertToDto(employeeService.save(employee));
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

    private EmployeeDTO convertToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }
}
