package com.luarnv00.quickstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.luarnv00.quickstart.model.User;
import com.luarnv00.quickstart.repository.UserRepository;
import com.luarnv00.quickstart.service.HelloService;

@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    private UserRepository userRepository;

    @GetMapping("/hello")
    public String index(@RequestParam(value = "name", defaultValue = "world", required = false) String name) {
        return this.service.sayHello(name);
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> listAllNames() {
        return userRepository.findAll();
    }
}
