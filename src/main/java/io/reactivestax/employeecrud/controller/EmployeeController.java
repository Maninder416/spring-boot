package io.reactivestax.employeecrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/hello")
    public String helloEmployee(){
        return "App is running";
    }
}
