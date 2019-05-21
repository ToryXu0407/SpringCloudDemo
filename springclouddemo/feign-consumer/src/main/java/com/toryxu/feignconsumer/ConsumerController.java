package com.toryxu.feignconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: toryxu
 * @Date: 2019/4/28 0028 13:20
 * @Version 1.0
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(@RequestParam(value = "name", defaultValue = "toryxu") String name){
        return helloService.hello(name);
    }

    @RequestMapping(value = "feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer(){
        helloService.hello2(new User("TORYXU",30));
        return "yes";
    }
}
