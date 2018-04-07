package com.study.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RabbitMQTopicConfig.class)
public class RabbitMQFanoutConfig {

    @Bean(name = "fanout_message1")
    public Queue queue(){
        return new Queue("fanout.message");
    }

    @Bean(name = "fanout_message2")
    public Queue queue2(){
        return new Queue("fanout.messages");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("exchange_fanout");
    }
    @Bean
    public Binding bindingExchangeMessage(@Qualifier("fanout_message1") Queue queue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeMessages(@Qualifier("fanout_message2") Queue queue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}
