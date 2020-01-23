package com.dev.ep.employeeportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Designation designation;

    @Column
    private Location location;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime editedAt;

    @Column
    private boolean active;

    protected Employee() {
    }

    public Employee(String firstName, String lastName, Designation designation, Location location, LocalDateTime createdAt, LocalDateTime editedAt, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.designation = designation;
        this.location = location;
        this.createdAt = createdAt;
        this.editedAt = editedAt;
        this.active = active;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getEditedAt() {
        return editedAt;
    }

    public void setEditedAt(LocalDateTime editedAt) {
        this.editedAt = editedAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", designation=" + designation +
                ", location=" + location +
                ", createdAt=" + createdAt +
                ", editedAt=" + editedAt +
                ", active=" + active +
                '}';
    }
}
