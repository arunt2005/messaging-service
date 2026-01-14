package com.apps.listener;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "messaging.broker", havingValue = "rabbitmq")
public class RabbitMqMessageListener {

    @RabbitListener(queues = "${messaging.queue}")
    public void onMessage(String message) {
        System.out.println("📩 RabbitMQ received message: " + message);
    }

    @Bean
    public Queue testQueue() {
        return new Queue("test.queue", true);
    }
}

