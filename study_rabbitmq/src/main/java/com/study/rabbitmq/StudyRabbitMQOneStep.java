package com.study.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class StudyRabbitMQOneStep {

    private final static String QUEUE_NAME = "HELLO";

    public static void main(String[] args){
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("118.24.111.118");
            connectionFactory.setPort(5672);
            connectionFactory.setUsername("test");
            connectionFactory.setPassword("test");
            connectionFactory.setVirtualHost("test");
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String message = "Hello Worldeeeee!";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes("UTF-8"));
            System.out.println("[x] Sent '"+message+"'");
            channel.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
