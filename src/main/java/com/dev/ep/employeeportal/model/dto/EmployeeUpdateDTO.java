package com.dev.ep.employeeportal.model.dto;

import com.dev.ep.employeeportal.model.Designation;
import com.dev.ep.employeeportal.model.Location;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class EmployeeUpdateDTO {

    private String firstName;
    private String lastName;
    private Designation designation;
    private Location location;
    @JsonIgnore
    private LocalDateTime editedAt = LocalDateTime.now();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDateTime getEditedAt() {
        return editedAt;
    }

    public void setEditedAt(LocalDateTime editedAt) {
        this.editedAt = editedAt;
    }
}
