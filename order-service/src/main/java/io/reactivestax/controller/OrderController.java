package io.reactivestax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order-payment")
    public String invokePaymentService() {
        String url = "http://PAYMENT-SERVICE/payment";
        return restTemplate.getForObject(url, String.class);
    }
}
