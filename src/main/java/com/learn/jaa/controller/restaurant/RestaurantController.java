package com.learn.jaa.controller.restaurant;

import org.springframework.web.bind.annotation.*;

/**
 * @author Krishna Chaitanya
 */
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @GetMapping
    public String hello() {
        return "Hello, restaurant!";
    }

}
