package com.toryxu.redisdemo;

import redis.clients.jedis.JedisPubSub;

/**
 * @Author: toryxu
 * @Date: 2019/4/4 0004 15:48
 * @Version 1.0
 */
public class RedisMsgSubListener extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println(message);
        super.onMessage(channel, message);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        super.onPMessage(pattern, channel, message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        super.onSubscribe(channel, subscribedChannels);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        super.onUnsubscribe(channel, subscribedChannels);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        super.onPUnsubscribe(pattern, subscribedChannels);
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        super.onPSubscribe(pattern, subscribedChannels);
    }


}
