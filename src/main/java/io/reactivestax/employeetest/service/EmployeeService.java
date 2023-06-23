package io.reactivestax.employeetest.service;

import io.reactivestax.employeetest.entity.Employee;
import io.reactivestax.employeetest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeeById(Long id){
        Optional<Employee> employeeId = employeeRepository.findById(id);
        if(employeeId.isEmpty()){
            throw new RuntimeException("Employee not found for id: "+employeeId);
        }
        return employeeId;
    }

    public void deleteEmployee(Long id){
        Optional<Employee> employeeId = employeeRepository.findById(id);
        if(employeeId.isEmpty()){
            throw new RuntimeException("Employee not found for id: "+employeeId);
        }
        employeeRepository.deleteById(id);

    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
