package com.example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CleverHelloController {

    @RequestMapping("/test/{name}")
    String home(@PathVariable String name) {
        return "Hello " + name + "!";
    }
}
