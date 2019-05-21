package com.toryxu.eurekaclient2;

import org.springframework.stereotype.Service;

/**
 * @Author: toryxu
 * @Date: 2019/4/30 0030 15:36
 * @Version 1.0
 */
@Service
public class HelloService {

    public String hello(String name,String port){
        return "hi " + name + " ,i am from port:" + port;
    }

    public String hello2(User user){
        return "hi  i am " + user.getName();
    }
}
