package com.example.springbootapi.controller.v1;

import com.example.springbootapi.entity.Employee;
import com.example.springbootapi.model.EmployeeRequest;
import com.example.springbootapi.model.EmployeeResponse;
import com.example.springbootapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * PathVariable : /v1/employee/12
     * PathVariable : /v1/employee/huda //404
     * Query Param : /v1/employee?page=0
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EmployeeResponse findEmployeeById(@PathVariable int id) throws Exception {
        Employee employee = employeeService.findById(id);

        return EmployeeResponse.getFromEntity(employee);
    }

    @GetMapping
    public List<EmployeeResponse> findAllEmployees() throws Exception {
        List<Employee> employees = employeeService.findAll();

        return employees.stream()
                .map(EmployeeResponse::getFromEntity)
                .collect(Collectors.toList());
    }

    //@RequestMapping(method = RequestMethod.POST)
    //kalo mau validasi, harus ada annotation @Valid di controllernya supaya bean validationnya jalan
    @PostMapping
    public EmployeeResponse createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) throws Exception {
        Employee employee = Employee.getEmployeeFromRequest(employeeRequest);

        Employee dataSaved = employeeService.save(employee);

        return EmployeeResponse.getFromEntity(dataSaved);
    }

    @DeleteMapping("/{id}")
    public EmployeeResponse deleteEmployeeById(@PathVariable int id) throws Exception {
        Employee deletedData = employeeService.delete(id);

        return EmployeeResponse.getFromEntity(deletedData);
    }

    @PutMapping("/{id}")
    public EmployeeResponse updateEmployeeById(
            @PathVariable int id,
            @RequestBody EmployeeRequest employeeRequest
    ) {
        Employee employee = Employee.getEmployeeFromRequest(employeeRequest);

        Employee updatedData = employeeService.update(id, employee);

        return EmployeeResponse.getFromEntity(updatedData);
    }
}
