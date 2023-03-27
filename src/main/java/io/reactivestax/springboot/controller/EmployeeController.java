package io.reactivestax.springboot.controller;

import io.reactivestax.springboot.entity.Employee;
import io.reactivestax.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    @GetMapping("/employees/{id}"   )
    public ResponseEntity<String> getEmployeeById(@PathVariable("id") Long id){
        return ResponseEntity.ok(employeeService.findEmployeeUsingId(id));
    }
    @PostMapping("/employees")
    public ResponseEntity<Employee> employee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.postEmployee(employee));
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")Long id){
        return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
    }
}
