package com.toryxu.feignconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: toryxu
 * @Date: 2019/4/28 0028 13:19
 * @Version 1.0
 */
@FeignClient("service-hi")
public interface HelloService {

    @RequestMapping("/hi")
    String hello(@RequestParam("name") String name);

    @RequestMapping("/hello")
    String hello2(@RequestBody User user);
}
