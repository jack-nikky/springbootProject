package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@RestController
@MapperScan("com.itheima.mapper")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/hello")
    public String hello(){
        return "hello, my springboot project";
    }

    @GetMapping("/user/{id}")
    public User queryById(@PathVariable Long id)  {
        return userService.queryById(id);
    }
}
