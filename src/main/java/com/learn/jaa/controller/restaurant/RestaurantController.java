package com.learn.jaa.controller.restaurant;

import org.springframework.security.access.prepost.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Krishna Chaitanya
 */
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @GetMapping
    @PreAuthorize("hasRole('admin')")
    public String hello() {
        return "Hello, restaurant!";
    }

}
