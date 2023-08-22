package io.reactivestax.httpsecurity.service;

import io.reactivestax.httpsecurity.entity.Employee;
import io.reactivestax.httpsecurity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployeeById(Integer employeeId) {
        Optional<Employee> byId = employeeRepository.findById(employeeId);
        if (byId.isEmpty()) {
            throw new RuntimeException("Employee not found for id :{} " + employeeId);
        }
        return byId;
    }

    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    public String deleteEmployeeById(Integer id){
        Optional<Employee> byId= employeeRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Employee not found for id :{} " + id);
        }
        employeeRepository.deleteById(byId.get().getId());
        return "Employee "+id+"  is deleted";
    }

    public Optional<Employee> updateEmployee(Employee employee){
        Optional<Employee> byId = employeeRepository.findById(employee.getId());
        if (byId.isEmpty()) {
            throw new RuntimeException("Employee not found for id :{} " + employee.getId());
        }
        byId.get().setDepartment(employee.getDepartment());
        byId.get().setName(employee.getName());
        return byId;
    }


}
