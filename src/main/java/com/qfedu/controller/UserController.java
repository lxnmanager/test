package com.qfedu.controller;

import com.qfedu.domain.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    //注册
    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    @ResponseBody
    public String register(User user){
        if (service.insert(user)>0){
            return "ok";
        }
        return "worng";
    }
    //登录
    @PostMapping(value = "/login.do")
    @ResponseBody
    public String login(String name, String password){
        if (service.selectLogin(name,password)!=null){
            return "ok";
        }
        return "worng";
    }
}
