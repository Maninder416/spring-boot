package io.reactivestax.controller;

import io.reactivestax.entity.Department;
import io.reactivestax.entity.Employee;
import io.reactivestax.repository.DepartmentRepository;
import io.reactivestax.repository.EmployeeRepository;
import io.reactivestax.request.EmployeeRequest;
import io.reactivestax.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
//    @Transactional
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeRequest request) {

        return new ResponseEntity<>(employeeService.saveEmployee(request), HttpStatus.CREATED);

    }
}
