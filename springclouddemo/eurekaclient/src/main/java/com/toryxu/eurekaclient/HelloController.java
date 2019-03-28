package com.toryxu.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: toryxu
 * @Date: 2019/3/28 0028 14:42
 * @Version 1.0
 */
@RestController
public class HelloController {

//    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String index(){
//        List<String> services = client.getServices();
//        logger.info(services.toString());
//        logger.info("/hello,host:"+ instance.getHost() + ",Service_id："+ instance.getServiceId());
        return "Hello World";
    }
}
