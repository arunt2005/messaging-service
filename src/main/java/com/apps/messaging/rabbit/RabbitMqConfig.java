package com.apps.messaging.rabbit;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("rabbitmq")
public class RabbitMqConfig {
    @Bean
    public DirectExchange appExchange() {
        return new DirectExchange("app.exchange");
    }

}
