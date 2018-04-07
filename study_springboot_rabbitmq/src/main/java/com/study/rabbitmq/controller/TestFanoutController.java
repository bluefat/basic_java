package com.study.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/testfanout")
public class TestFanoutController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/send")
    public void send(){
        amqpTemplate.convertAndSend("exchange_fanout","","HELLO");
    }

    @RabbitListener(queues = "fanout.message")
    private void receive(String str){
        System.out.println(" 接受到消息fanout：" + str);
    }

    @RabbitListener(queues = "fanout.messages")
    private void receives(String str){
        System.out.println(" 接受到消息fanout：" + str);
    }
}
