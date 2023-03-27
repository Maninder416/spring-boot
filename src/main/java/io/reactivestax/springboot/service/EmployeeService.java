package io.reactivestax.springboot.service;

import io.reactivestax.springboot.entity.Employee;
import io.reactivestax.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee postEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public String findEmployeeUsingId(Long id){
        Optional<Employee> employee= employeeRepository.findById(id);
        if(employee.isEmpty()){
            return "Employee not found for id: "+id;
        }
        return employeeRepository.findById(id).toString();
    }

    public String deleteEmployeeById(Long id){
        Optional<Employee> employee= employeeRepository.findById(id);
        if(employee.isEmpty()){
            return "Employee not found for id: "+id;
        }
        return "Employee associated with id : "+id+" deleted";
    }
}
