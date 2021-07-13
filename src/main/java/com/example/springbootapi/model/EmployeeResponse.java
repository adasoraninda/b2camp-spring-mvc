package com.example.springbootapi.model;

import com.example.springbootapi.entity.Employee;

import java.util.List;

public class EmployeeResponse {

    private int id;
    private String name;
    private String address;
    private List<String> hobby;

    public EmployeeResponse() {
    }

    private EmployeeResponse(int id, String name, String address, List<String> hobby, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.hobby = hobby;
    }

    public static EmployeeResponse getFromEntity(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getAddress(),
                employee.getHobby(),
                employee.getSalary()
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

}
