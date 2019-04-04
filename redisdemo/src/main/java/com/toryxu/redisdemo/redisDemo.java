package com.toryxu.redisdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.util.Set;

/**
 * @Author: toryxu
 * @Date: 2019/4/4 0004 15:25
 * @Version 1.0
 */
public class redisDemo {
    private static final String ADDR = "120.79.213.75";
    private static final int PORT = 6379;
    private static JedisPool jedisPool = new JedisPool(ADDR, PORT);
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
    public static void main(String[] args) {
        Jedis jedis = redisDemo.getJedis();
        jedis.zadd("我爱你",100,"骗你的！");
        Set<Tuple> set = jedis.zrangeWithScores("我爱你",0,1);
//        System.out.println(((Tuple)set.toArray()[0]).getElement());
//        System.out.println(((Tuple)set.toArray()[0]).getScore());
        RedisMsgSubListener redisMsgSubListener = new RedisMsgSubListener();
        jedis.subscribe(redisMsgSubListener,"test");
    }
}

