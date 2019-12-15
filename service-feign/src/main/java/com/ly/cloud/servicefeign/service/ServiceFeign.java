package com.ly.cloud.servicefeign.service;

import com.ly.cloud.servicefeign.service.impl.ServiceFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//调用的服务名，及熔断器fallback方法
@FeignClient(value = "hello-service",fallback = ServiceFeignImpl.class)
public interface ServiceFeign {

    @RequestMapping(value = "/hi/feign-{name}",method = RequestMethod.GET)
    String sayHiFromClientOne(@PathVariable(value = "name") String name);

}
