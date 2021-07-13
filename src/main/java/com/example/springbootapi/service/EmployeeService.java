package com.example.springbootapi.service;

import com.example.springbootapi.entity.Employee;
import com.example.springbootapi.exception.BusinessCode;
import com.example.springbootapi.exception.BusinessException;
import com.example.springbootapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired //autowired -> inisialisasi data diinject oleh spring saat aplikasi dijalankan
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() throws Exception {
        List<Employee> employees = employeeRepository.findAll();

        if (employees.isEmpty()) {
            throw new BusinessException(BusinessCode.DATA_NOT_EXIST);
        }

        return employees;
    }

    public Employee findById(int id) throws Exception {
        Employee employee = employeeRepository.findById(id);

        if (employee == null) {
            throw new BusinessException(BusinessCode.DATA_NOT_EXIST);
        }

        return employee;
    }

    public Employee save(Employee employee) throws Exception {
        Employee exist = employeeRepository.findById(employee.getId());

        if (exist != null) {
            throw new BusinessException(BusinessCode.DATA_ALREADY_EXIST);
        }

        double netSalary = (employee.getSalary() - (employee.getSalary() * 0.1));
        employee.setSalary(netSalary);

        return employeeRepository.save(employee);
    }

    public Employee delete(int id) {
        Employee employee = employeeRepository.findById(id);

        if (employee == null) {
            throw new BusinessException(BusinessCode.DATA_NOT_EXIST);
        }

        return employeeRepository.delete(id);
    }

    public Employee update(int id, Employee newEmployeeData) {
        Employee employee = employeeRepository.findById(id);

        if (employee == null) {
            throw new BusinessException(BusinessCode.DATA_NOT_EXIST);
        }

        return employeeRepository.update(id, newEmployeeData);
    }

}
