package com.example.springbootapi.entity;

import com.example.springbootapi.model.EmployeeRequest;

import java.util.List;

public class Employee {
    private int id;
    private String name;
    private String address;
    private List<String> hobby;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, String address, List<String> hobby, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.hobby = hobby;
        this.salary = salary;
    }

    public static Employee getEmployeeFromRequest(EmployeeRequest employeeRequest) {
        return new Employee(
                employeeRequest.getId(),
                employeeRequest.getName(),
                employeeRequest.getAddress(),
                employeeRequest.getHobby(),
                employeeRequest.getSalary()
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
