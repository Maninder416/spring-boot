package io.reactivestax.employeetest.service;

import io.reactivestax.employeetest.entity.Employee;
import io.reactivestax.employeetest.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeeById(Long id) {
        log.info("Getting Employee details using ID");
        Optional<Employee> employeeId = employeeRepository.findById(id);
        if (employeeId.isEmpty()) {
            throw new RuntimeException("Employee not found for id: " + employeeId);
        }
        return employeeId;
    }

    public void deleteEmployee(Long id) {
        log.info("Deleting Employee using ID");
        Optional<Employee> employeeId = employeeRepository.findById(id);
        if (employeeId.isEmpty()) {
            throw new RuntimeException("Employee not found for id: " + employeeId);
        }
        employeeRepository.deleteById(id);

    }

    public Employee saveEmployee(Employee employee) {
        log.info("Saving new employee");
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        log.info("Update Employee using ID");
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee1 = optionalEmployee.get();
        if (optionalEmployee.isPresent()) {
            employee1.setName(employee.getName());
            employee1.setPostalCode(employee.getPostalCode());
            employee1.setSalary(employee.getSalary());
        }
        return employeeRepository.save(employee1);
    }

    public Employee updateEmployeePartially(Long id, String name) {
        log.info("updating partial information of Employee");
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee1 = optionalEmployee.get();
        if (optionalEmployee.isPresent()) {
            employee1.setName(name);
        }
        return employeeRepository.save(employee1);
    }
}
