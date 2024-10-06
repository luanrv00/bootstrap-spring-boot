package com.luarnv00.quickstart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luarnv00.quickstart.model.User;
import com.luarnv00.quickstart.repository.UserRepository;

@Service
public class HelloService {

    @Autowired
    UserRepository userRepository;

    public String sayHello(String name) {
        return String.format("hello %s", name);
    }

    public Iterable<User> getAllNames() {
        return this.userRepository.findAll();
    }

    public User addName(String name) {
        User user = new User();
        user.setName(name);
        this.userRepository.save(user);
        return user;
    }
}