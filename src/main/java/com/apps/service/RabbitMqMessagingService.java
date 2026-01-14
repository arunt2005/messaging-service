package com.apps.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "messaging.broker", havingValue = "rabbitmq")
public class RabbitMqMessagingService implements MessagingService {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqMessagingService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publish(String destination, String message) {
        rabbitTemplate.convertAndSend(destination, message);
    }

    @Override
    public void subscribe(String destination) {
        // handled via @RabbitListener
    }
}
