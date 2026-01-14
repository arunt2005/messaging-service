package com.apps.messaging.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("rabbitmq")
public class RabbitMqConfig {

    @Bean
    public Queue testQueue() {
        return new Queue("test.queue", true);
    }

    @Bean
    public DirectExchange appExchange() {
        return new DirectExchange("app.exchange");
    }

    @Bean
    public Binding binding(Queue testQueue, DirectExchange appExchange) {
        return BindingBuilder.bind(testQueue).to(appExchange).with("app.routing.key");
    }
}
