//package io.reactivestax.springboot.controller;
//
//import io.reactivestax.springboot.entity.Employee;
//import io.reactivestax.springboot.repository.EmployeeRepository;
//import io.reactivestax.springboot.service.EmployeeService;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class EmployeeControllerTests {
//    @Autowired
//    private MockMvc mockMvc;
//    @Mock
//    private EmployeeRepository employeeRepository;
//    @InjectMocks
//    private EmployeeService employeeService;
//
//    @Test
//    public void findEmployee() throws Exception {
//        System.out.println("find employee");
//        Employee employee = Employee.builder()
//                .id(5l)
//                .name("brijesh")
//                .employment("dev")
//                .build();
//        List<Employee> employeeList= new ArrayList<>();
//        employeeList.add(employee);
//        given(employeeRepository.findAll()).willReturn(employeeList);
//        List<Employee> expectedList= employeeService.getAllEmployees();
//        Assertions.assertEquals(expectedList,employeeList);
//        verify(employeeRepository).findAll();
//    }
//
//    @Test
//    public void postEmployee(){
//        System.out.println("post employee");
//        Employee employee = Employee.builder()
//                .id(5l)
//                .name("brijesh")
//                .employment("dev")
//                .build();
//        when(employeeRepository.save(ArgumentMatchers.any(Employee.class)))
//                .thenReturn(employee);
//        Employee created= employeeService.postEmployee(employee);
//        Assertions.assertEquals(created,employee);
//    }
//    @Test
//    public void deleteEmployee(){
//       Employee employee = Employee.builder()
//                .id(2l)
//                .name("tester")
//                .employment("dev")
//                .build();
//
//        when(employeeRepository.findById(employee.getId()))
//                .thenReturn(Optional.of(employee));
//        employeeService.deleteEmployeeById(employee.getId());
//    }
//
//
//
//
//}
