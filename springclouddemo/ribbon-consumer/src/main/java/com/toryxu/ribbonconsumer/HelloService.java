package com.toryxu.ribbonconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: toryxu
 * @Date: 2019/4/11 0011 13:48
 * @Version 1.0
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "serviceFailure")
    public String helloService(){
        return restTemplate.getForEntity("http://service-hi/hi",String.class).getBody();
    }
    public String serviceFailure(){
        return "error";
    }
}
