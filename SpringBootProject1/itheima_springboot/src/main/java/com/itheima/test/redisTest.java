package com.itheima.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class redisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        //string字符串
        //方法一
        //redisTemplate.opsForValue().set("str","itcast");
        //System.out.println("str= " + redisTemplate.opsForValue().get("str"));
        //方法二
        redisTemplate.boundValueOps("str").set("itheima");
        System.out.println("str= " + redisTemplate.boundValueOps("str").get());

        //hash散列
        redisTemplate.boundHashOps("h_key").put("name","itheima");
        redisTemplate.boundHashOps("h_key").put("age","13");
        //获取所有域(hk列）
        Set set = redisTemplate.boundHashOps("h_key").keys();
        System.out.println("hsah散列的所有域="+ set);
        //获取所有值
        List list = redisTemplate.boundHashOps("h_key").values();
        System.out.println("hsah散列的所有域的值="+ list);


        //list列表
        redisTemplate.boundListOps("l_key").leftPush("c");
        redisTemplate.boundListOps("l_key").leftPush("d");
        redisTemplate.boundListOps("l_key").leftPush("e");
        //获取全部元素
        List l_key = redisTemplate.boundListOps("l_key").range(0, -1);
        System.out.println("list列表中所有元素是"+l_key);

        //set集合
        redisTemplate.boundSetOps("S_key").add("a","b","c");
        Set setset = redisTemplate.boundSetOps("s_key").members();
        System.out.println("集合的全部元素="+setset);
        //sorted set有序集合
        redisTemplate.boundZSetOps("z_key").add("a",30);
        redisTemplate.boundZSetOps("z_key").add("b",20);
        redisTemplate.boundZSetOps("z_key").add("c",10);
        Set z_key = redisTemplate.boundZSetOps("z_key").range(0, -1);
        System.out.println("zset有序集合中的所有元素"+z_key);

    }

}