package io.reactivestax.service;

import io.reactivestax.entity.Department;
import io.reactivestax.entity.Employee;
import io.reactivestax.repository.DepartmentRepository;
import io.reactivestax.repository.EmployeeRepository;
import io.reactivestax.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Employee saveEmployee(EmployeeRequest request){
        Department department = new Department();
        department.setName(request.getName());
        department = departmentRepository.save(department);
        Employee employee = new Employee(request);
        employee.setDepartment(department);

        if (department.getName().contains("robin")) {
            throw new RuntimeException("Testing");
        }
        employee = employeeRepository.save(employee);
        return employee;
    }


}
