package com.study.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestDirectController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "send")
    public void send(){
        amqpTemplate.convertAndSend("HELLO","yes");
    }

    @RabbitListener(queues = "HELLO")
    private void receive(String str){
        System.out.println(" 接受到消息direct：" + str);
    }
}
