package com.luarnv00.quickstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.luarnv00.quickstart.model.User;
import com.luarnv00.quickstart.service.HelloService;

@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    @GetMapping("/hello")
    public String index(@RequestParam(value = "name", defaultValue = "world", required = false) String name) {
        return this.service.sayHello(name);
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> listAllNames() {
        return this.service.getAllNames();
    }

    @PostMapping("/hello/add")
    public ResponseEntity<User> addName(@RequestBody String name) {
        User savedUser = this.service.addName(name);
        final ResponseEntity<User> response = new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
        return response;
    }
}
