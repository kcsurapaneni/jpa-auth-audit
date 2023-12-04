package com.learn.jaa.controller;

import lombok.extern.slf4j.*;
import org.springframework.security.core.context.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Krishna Chaitanya
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @GetMapping
    public String getString() {
        log.info("security principal: {}", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "Hello, world!";
    }

}
