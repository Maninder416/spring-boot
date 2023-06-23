package io.reactivestax.employeetest.controller;

import io.reactivestax.employeetest.entity.Employee;
import io.reactivestax.employeetest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee employee) {
        System.out.println("Employee body: " + employee);
        return employeeService.saveEmployee(employee);

    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> findEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/salary")
    public Map<Double, List<Employee>> employeeListWithSalary() {
        Map<Double, List<Employee>> collect = employeeService.findAllEmployees()
                .stream()
                .collect(Collectors.groupingBy(a -> a.getSalary()));
        return collect;
    }

    @GetMapping("/postalCode")
    public Map<String, List<Employee>> employeeListByPostalCode() {
        return employeeService.findAllEmployees()
                .stream()
                .collect(Collectors.groupingBy(a -> a.getPostalCode()));
    }

    @GetMapping("/max")
    public Employee highestEmployeeSalary() {
        return employeeService.findAllEmployees()
                .stream()
                .max((a, b) -> (int) (a.getSalary() - b.getSalary())).get();
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @PatchMapping("/employees/{id}/{name}")
    public Employee updateEmployeePartially(@PathVariable Long id, @PathVariable String name){
        return employeeService.updateEmployeePartially(id,name);
    }



}
