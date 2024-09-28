package com.luarnv00.quickstart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String index(@RequestParam(value = "name", defaultValue = "world", required = false) String name) {
        return String.format("hello %s", name);
    }
}
