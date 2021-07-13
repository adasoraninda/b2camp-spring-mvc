package com.example.springbootapi.controller.v2;

import com.example.springbootapi.entity.Employee;
import com.example.springbootapi.model.BaseResponse;
import com.example.springbootapi.model.EmployeeRequest;
import com.example.springbootapi.model.EmployeeResponse;
import com.example.springbootapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeV2Controller {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public BaseResponse<List<EmployeeResponse>> findAllEmployees() throws Exception {
        List<EmployeeResponse> employees = employeeService.findAll()
                .stream()
                .map(EmployeeResponse::getFromEntity)
                .collect(Collectors.toList());

        return BaseResponse.success(employees);
    }

    @PostMapping
    public BaseResponse<EmployeeResponse> createEmployee(
            @Valid @RequestBody EmployeeRequest employeeRequest
    ) throws Exception {
        Employee employee = Employee.getEmployeeFromRequest(employeeRequest);
        Employee dataSaved = employeeService.save(employee);
        EmployeeResponse employeeResponse = EmployeeResponse.getFromEntity(dataSaved);

        return BaseResponse.success(employeeResponse);
    }

}
