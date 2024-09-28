package com.luarnv00.quickstart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public @ResponseBody String index(@RequestParam(value = "name", defaultValue = "world") String name) {
        return String.format("hello %s", name);
    }
}
