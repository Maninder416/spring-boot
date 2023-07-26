package io.reactivestax.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping("/payment")
    public String hello(){
        return "Payment class is calling";
    }
}
