package com.toryxu.ribbonconsumer;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: toryxu
 * @Date: 2019/4/11 0011 15:42
 * @Version 1.0
 */
public class UserCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private Long id;

    public UserCommand(Setter setter,RestTemplate restTemplate,Long id){
        super(setter);
        this.restTemplate = restTemplate;
        this.id =id;
    }
    @CacheResult(cacheKeyMethod = "setCacheKey")
    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}",User.class,id);
    }

    public Long setCacheKey(Long id){
        return id;
    }

    public static void main(String[] args) {
    }
}
