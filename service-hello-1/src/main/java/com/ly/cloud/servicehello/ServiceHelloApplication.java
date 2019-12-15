package com.ly.cloud.servicehello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@EnableEurekaClient
public class ServiceHelloApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceHelloApplication.class, args);

    }
    @Value("${server.port}")
    String port;
    @GetMapping("/hi/{name}")
    public String home(@PathVariable String name) {
        return "hi "+name+",i am from port:" +port;
    }

}
