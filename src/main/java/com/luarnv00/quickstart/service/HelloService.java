package com.luarnv00.quickstart.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello(String name) {
        return String.format("hello %s", name);
    }
}