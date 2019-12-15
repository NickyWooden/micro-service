package com.ly.cloud.serviceribbon.service;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    //熔断器注解，fallback方法，指定服务不可用时执行的备用方法
    @HystrixCommand(fallbackMethod = "errorMsg")
    public String callRestService(String name){

        return restTemplate.getForObject("http://hello-service/hi/"+name,String.class);

    }
    public String errorMsg(String name){
        return "service failure! "+name;
    }

}
