package com.toryxu.redisdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author: toryxu
 * @Date: 2019/4/4 0004 15:55
 * @Version 1.0
 */
public class RedisMsgPub {
    private static final String ADDR = "120.79.213.75";
    private static final int PORT = 6379;
    private static JedisPool jedisPool = new JedisPool(ADDR, PORT);
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void main(String[] args) {
        RedisMsgPub.getJedis().publish("test","我是脑袋");
    }
}
