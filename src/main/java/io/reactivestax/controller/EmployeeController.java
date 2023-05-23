package io.reactivestax.controller;

import io.reactivestax.entity.Department;
import io.reactivestax.entity.Employee;
import io.reactivestax.repository.DepartmentRepository;
import io.reactivestax.repository.EmployeeRepository;
import io.reactivestax.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeRequest request){
        Department department= new Department();
        department.setName(request.getName());
        department= departmentRepository.save(department);
        Employee employee = new Employee(request);
        employee.setDepartment(department);
        employee= employeeRepository.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);

    }
}
