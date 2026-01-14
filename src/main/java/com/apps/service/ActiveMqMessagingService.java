package com.apps.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "messaging.broker", havingValue = "activemq")
public class ActiveMqMessagingService implements MessagingService {

    private final JmsTemplate jmsTemplate;

    public ActiveMqMessagingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void publish(String destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    @Override
    public void subscribe(String destination) {
        // JMS Listener handled via @JmsListener
    }
}
