package com.learn.jaa.controller.order;

import org.springframework.security.access.prepost.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Krishna Chaitanya
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping
    @PreAuthorize("hasAnyAuthority('normal')")
    public String hello() {
        return "Hello, order!";
    }

}
