package com.itheima.service;

import com.itheima.mapper.ExpressMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Express;
import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressService {
    @Autowired
    private ExpressMapper expressMapper;

    public List<Express>  queryAll(){
        return expressMapper.selectAll();
    }

    public void addExpress(Express express){
        expressMapper.insertSelective(express);
    }
}
