package io.reactivestax.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order-payment")
    public String invokePaymentService() {
        String url = "http://PAYMENT-SERVICE/payment";
        log.info("****** Invoking payment method ******");
        return restTemplate.getForObject(url, String.class);
    }
}
