package com.example.springbootapi.repository;

import com.example.springbootapi.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * tempat pengambilan data atau manipulasi data (query jika memakasi database)
 */

/**
 * @Component
 * @Repository
 * @Service
 * @Controller
 */
@Repository
public class EmployeeRepository {

    /**
     * Mock database
     * 1 - Deni
     * 2 - Huda
     */
    private final HashMap<Integer, Employee> employees = new HashMap();

    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    public Employee findById(int id) {
        return employees.get(id);
    }

    public Employee save(Employee employee) {
        employees.put(employee.getId(), employee);

        return employee;
    }

    public Employee delete(int id) {
        Employee employee = employees.get(id);

        employees.remove(id);

        return employee;
    }

    public Employee update(int id, Employee newEmployeeData) {
        employees.replace(id, newEmployeeData);

        return employees.get(id);
    }

}
