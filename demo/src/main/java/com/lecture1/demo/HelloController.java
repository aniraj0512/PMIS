
package com.lecture1.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello! Spring Boot is working.";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
