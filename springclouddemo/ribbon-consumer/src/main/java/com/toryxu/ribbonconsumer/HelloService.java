package com.toryxu.ribbonconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

    @CacheResult(cacheKeyMethod = "getUserByIdCacheKey")
    @HystrixCommand
    public User getUserById(@CacheKey("id") Long id){
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}",User.class,id);
    }

    @HystrixCommand
    public List<User> findAll(){
        return new ArrayList<>();
    }

    //这边的commandKey是读方法的方法名
    @CacheRemove(commandKey = "getUserById")
    @HystrixCommand
    public User update(@CacheKey("id") User user){
        return restTemplate.postForObject("http://USER-SERVICE/user",user,User.class);
    }

    private Long getUserByIdCacheKey(Long id){
        return id;
    }
}
