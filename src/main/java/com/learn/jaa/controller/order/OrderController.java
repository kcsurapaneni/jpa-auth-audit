package com.learn.jaa.controller.order;

import org.springframework.web.bind.annotation.*;

/**
 * @author Krishna Chaitanya
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping
    public String hello() {
        return "Hello, order!";
    }

}
