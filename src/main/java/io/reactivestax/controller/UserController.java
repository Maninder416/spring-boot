package io.reactivestax.controller;

import io.reactivestax.entity.User;
import io.reactivestax.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private CustomUserDetailService service;

    @PostMapping("/user")
    public String addUser(@RequestBody User user){
        return service.addUser(user);
    }
}
