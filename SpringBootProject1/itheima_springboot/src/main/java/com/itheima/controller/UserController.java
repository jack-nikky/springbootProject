package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

//@RestController
@Controller
@MapperScan("com.itheima.mapper")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello, my springboot project";
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User queryById(@PathVariable Long id)  {
        return userService.queryById(id);
    }
}
