package com.study.springboot_dubbo_caller.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.study.springboot_dubbo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference(version = "1.1.0")
    private UserService userService;

    @RequestMapping(value = "/getname")
    public String getName(){
        return userService.getName();
    }
}
