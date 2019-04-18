package com.toryxu.ribbonconsumer;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCollapserKey;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.HystrixCommand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: toryxu
 * @Date: 2019/4/12 0012 15:03
 * @Version 1.0
 */
public class UserCollapseCommand extends HystrixCollapser<List<User>,User,Long> {

    private UserService userService;
    private Long userId;

    public UserCollapseCommand(UserService userService,Long userId){
        //合并器在100ms这窗口内收集单个请求并组装成单个批量请求
        super(Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey("userCollapseCommand")).andCollapserPropertiesDefaults(
                HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(100)
        ));
        this.userService = userService;
        this.userId = userId;
    }
    @Override
    public Long getRequestArgument() {
        return userId;
    }

    @Override
    protected HystrixCommand<List<User>> createCommand(Collection<CollapsedRequest<User, Long>> collection) {
        List<Long> userIds = new ArrayList<>(collection.size());
        //lambda语句，将collection内的每个实例调用getArgument方法并将返回值改成List类型
        userIds.addAll(collection.stream().map(CollapsedRequest::getArgument).collect(Collectors.toList()));
        return new UserBatchCommand(userService,userIds);
    }


    @Override
    protected void mapResponseToRequests(List<User> users, Collection<CollapsedRequest<User, Long>> collection) {
        int count = 0;
        for(CollapsedRequest<User,Long> collapsedRequest:collection){
            User user = users.get(count++);
            collapsedRequest.setResponse(user);
        }
    }
}
