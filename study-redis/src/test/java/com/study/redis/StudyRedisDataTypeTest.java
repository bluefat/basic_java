package com.study.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

import static org.junit.Assert.*;

public class StudyRedisDataTypeTest {

    public static final Jedis jedis = new Jedis("localhost");

    @Test
    public void linkRedis(){
        System.out.println("连接状态：" + jedis.ping());
    }

    @Test
    public void testString(){
        jedis.set("test0","康师傅方便面");
        System.out.println(jedis.get("test0"));
    }

    @Test
    public void testList(){
        jedis.lpush("listelement0","农夫山泉0");
        jedis.lpush("listelement1","农夫山泉1");
        jedis.lpush("listelement2","农夫山泉2");

        List<String> stringList = jedis.lrange("listelement0",0,10);

        for (String str : stringList) {
            System.out.println(str);
        }
    }

    @Test
    public void testHash(){

    }

    @Test
    public void testSet(){

    }

    @Test
    public void testSortedSet(){

    }
}