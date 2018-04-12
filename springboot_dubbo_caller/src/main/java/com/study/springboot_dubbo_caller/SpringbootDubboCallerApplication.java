package com.study.springboot_dubbo_caller;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.study.springboot_dubbo_caller.controller")
public class SpringbootDubboCallerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboCallerApplication.class, args);
	}
}
