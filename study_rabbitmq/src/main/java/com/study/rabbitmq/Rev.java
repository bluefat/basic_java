package com.study.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Rev {
    private final static String QUEUE_NAME = "HELLO";

    public static void main(String[] args){
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("118.24.111.118");
            connectionFactory.setPort(5672);
            connectionFactory.setUsername("test");
            connectionFactory.setPassword("test");
            connectionFactory.setVirtualHost("test");
            Channel channel = connectionFactory.newConnection().createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                }
            };
            channel.basicConsume(QUEUE_NAME, true, consumer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
