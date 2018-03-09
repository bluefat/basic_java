package com.study.redis;

import redis.clients.jedis.Jedis;

public class StudyRedisDataType {

    public static final Jedis jedis = new Jedis("localhost");

    public static void main(String[] args){

    }

    public void linkRedis(){
        System.out.println("连接状态：" + jedis.ping());
    }

    public void testString(){

    }

    public void testList(){

    }

    public void testHash(){

    }

    public void testSet(){

    }

    public void testSortedSet(){

    }
}
