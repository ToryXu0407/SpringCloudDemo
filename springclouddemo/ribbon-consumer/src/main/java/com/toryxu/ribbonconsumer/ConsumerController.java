package com.toryxu.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: toryxu
 * @Date: 2019/3/28 0028 22:23
 * @Version 1.0
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HelloService helloService;
    @RequestMapping(value="/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
       return helloService.helloService();
    }

    @RequestMapping(value="/getUser",method=RequestMethod.GET)
    public String getUser(Long id){
//        UserCommand userCommand(helloService,id);
        return null;
    }
}
