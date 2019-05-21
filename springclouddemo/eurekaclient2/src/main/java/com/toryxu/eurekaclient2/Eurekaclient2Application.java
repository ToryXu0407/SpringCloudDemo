package com.toryxu.eurekaclient2;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@RestController
public class Eurekaclient2Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaclient2Application.class, args);
    }
    //springboot 2.0之后需要配置这个
    @Bean
    public ServletRegistrationBean getServlet(){


        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);  //系统启动时加载顺序
        registrationBean.addUrlMappings("/hystrix.stream");//路径
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

    @Value("${server.port}")
    String port;

    @Autowired
    HelloService helloService;

    @HystrixCommand
    @RequestMapping("/hi")
    public String home(String name) {
        return helloService.hello(name,port);
    }

    @HystrixCommand
    @RequestMapping(value="/hello",method=RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return helloService.hello2(user);
    }
}
