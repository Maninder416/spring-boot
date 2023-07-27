package io.reactivestax.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping("/payment")
    public String hello(){
        logger.info("***** Calling hello method ******");
        return "Payment class is calling";
    }
}
