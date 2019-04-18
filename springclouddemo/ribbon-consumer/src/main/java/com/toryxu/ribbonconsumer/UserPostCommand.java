package com.toryxu.ribbonconsumer;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: toryxu
 * @Date: 2019/4/11 0011 15:42
 * @Version 1.0
 */
public class UserPostCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private User user;

    public UserPostCommand(Setter setter,RestTemplate restTemplate,User user){
        super(setter);
        this.restTemplate = restTemplate;
        this.user = user;
    }

    @Override
    protected User run() throws Exception {
        User r =  restTemplate.postForObject("http://USER-SERVICE/users/",user,User.class);
        UserObservableCommand.flushCache(user.getId());
        return r;
    }

    public static void main(String[] args) {
    }
}
