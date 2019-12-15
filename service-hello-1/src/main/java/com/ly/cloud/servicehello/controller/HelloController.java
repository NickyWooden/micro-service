package com.ly.cloud.servicehello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${server.port}")
    String port;
    @GetMapping("/hi/{name}")
    public String home(@PathVariable String name) {
        return "hi "+name+",i am from port:" +port;
    }
}
