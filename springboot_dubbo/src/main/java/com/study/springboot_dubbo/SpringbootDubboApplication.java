package com.study.springboot_dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.study.springboot_dubbo.service")
public class SpringbootDubboApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboApplication.class, args);
	}
}
