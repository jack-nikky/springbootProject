package com.itheima.controller;

import com.itheima.pojo.Express;
import com.itheima.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

@Controller
@MapperScan("com.itheima.mapper")
public class ExpressController {
    @Autowired
    private ExpressService expressService;




    @GetMapping("/")
    public String queryAll(Model model)  {
        List expresses = expressService.queryAll();
        model.addAttribute("expresses",expresses);
        return "show";
    }

    @PostMapping("/add")
    public String add( Express express) {
        expressService.addExpress(express);
        return  "redirect:/";
    }
}
