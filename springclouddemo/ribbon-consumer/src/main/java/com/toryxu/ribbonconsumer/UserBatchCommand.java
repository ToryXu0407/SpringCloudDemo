package com.toryxu.ribbonconsumer;

import com.netflix.hystrix.HystrixCommand;

import java.util.List;

import static com.netflix.hystrix.HystrixCommandGroupKey.Factory.asKey;

/**
 * @Author: toryxu
 * @Date: 2019/4/12 0012 14:45
 * @Version 1.0
 */
public class UserBatchCommand extends HystrixCommand<List<User>> {

    UserService userService;
    List<Long> userIds;

    public UserBatchCommand(UserService userService,List<Long> userIds){
        super(Setter.withGroupKey(asKey("userServiceCommand")));
        this.userIds = userIds;
        this.userService = userService;
    }

    @Override
    protected List<User> run() throws Exception {
//        return userService.findAll();
        return null;
    }
}
