package com.study.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class RabbitMQTopicConfig {

    @Bean(name = "topic_message1")
    public Queue queue(){
        return new Queue("topic.message");
    }

    @Bean(name = "topic_message2")
    public Queue queue2(){
        return new Queue("topic.messages");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("exchange");
    }
    @Bean
    public Binding bindingExchangeMessage(@Qualifier("topic_message1") Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("topic.message");
    }

    @Bean
    public Binding bindingExchangeMessages(@Qualifier("topic_message2") Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("topic.#");
    }
}
