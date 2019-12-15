package com.ly.cloud.servicefeign.service.impl;

import com.ly.cloud.servicefeign.service.ServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class ServiceFeignImpl implements ServiceFeign {
    @Override
    public String sayHiFromClientOne(String name) {
        return "hello-service failure! "+name;
    }
}
