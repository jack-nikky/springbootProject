package com.itheima.service;

import com.itheima.mapper.ExpressMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Express;
import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ExpressService {
    @Autowired
    private ExpressMapper expressMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public List  queryAll(){
        if(!redisTemplate.hasKey("express")){
            //第一次启动时 初始化所有的
            List<Express> expresses = expressMapper.selectAll();
            for (int i = 0; i < expresses.size(); i++) {
                redisTemplate.boundListOps("express").leftPush(expresses.get(i).getContent());
            }
        }
        return redisTemplate.boundListOps("express").range(0, -1);
    }

    public void addExpress(Express express){
        expressMapper.insertSelective(express);
        redisTemplate.boundListOps("express").leftPush(express.getContent());
    }
}
