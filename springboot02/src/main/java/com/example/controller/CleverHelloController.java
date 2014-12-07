package com.example.controller;

import com.example.entity.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CleverHelloController {

    @RequestMapping(value = "/test/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    Message home(@PathVariable String name) {
        return new Message("Hello " + name + "!");
    }
}
