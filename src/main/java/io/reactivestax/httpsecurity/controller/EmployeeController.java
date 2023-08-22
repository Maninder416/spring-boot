package io.reactivestax.httpsecurity.controller;

import io.reactivestax.httpsecurity.entity.Employee;
import io.reactivestax.httpsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.findAllEmployee();
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable Integer employeeId){
        return new ResponseEntity<>(employeeService.findEmployeeById(employeeId), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }



}
