package com.dev.ep.employeeportal.repository;

import com.dev.ep.employeeportal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
