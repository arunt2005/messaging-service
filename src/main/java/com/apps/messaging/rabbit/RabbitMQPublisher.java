package com.apps.messaging.rabbit;

import com.apps.messaging.MessagePublisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("rabbitmq")
public class RabbitMQPublisher implements MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publish(String message) {
        rabbitTemplate.convertAndSend("app.exchange", "app.routing.key", message);
    }
}
