package com.apps.messaging.activemq;

import com.apps.messaging.MessagePublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile("activemq")
public class ActiveMQPublisher implements MessagePublisher {

    private final JmsTemplate jmsTemplate;

    public ActiveMQPublisher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void publish(String message) {
        jmsTemplate.convertAndSend("app.queue", message);
    }
}
