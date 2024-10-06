package com.luarnv00.quickstart.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.luarnv00.quickstart.model.User;
import com.luarnv00.quickstart.service.HelloService;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private HelloService service;

    @Test
    void getHelloReturnsDefaultMessage() throws Exception {
        when(this.service.sayHello(null)).thenReturn("hello world");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello world")));
    }

    @Test
    void getHelloReturnsDynamicMessage() throws Exception {
        when(this.service.sayHello("asdf")).thenReturn("hello asdf");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=asdf")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello asdf")));
    }

    @Test
    void postAddReturnsStatusCreated() throws Exception {
        String mockName = "supername";
        User mockUser = new User();
        mockUser.setName(mockName);
        when(this.service.addName(mockName)).thenReturn(mockUser);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/hello/add")
                .content(mockName)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void postAddReturnsSavedName() throws Exception {
        String mockName = "supername";
        User mockUser = new User();
        mockUser.setName(mockName);
        when(this.service.addName(mockName)).thenReturn(mockUser);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/hello/add")
                .content(mockName)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(mockName));
    }
}
