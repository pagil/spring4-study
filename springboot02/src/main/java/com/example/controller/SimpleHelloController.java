package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleHelloController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
