package com.study.springboot_dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.study.springboot_dubbo.service.UserService;

@Service(version = "1.1.0")
public class UserServiceImpl implements UserService{
    @Override
    public String getName() {
        System.out.println("服务被调用");
        return "你找到我了！";
    }
}
