package com.apps.controller;

import com.apps.dto.MessageRequest;
import com.apps.service.MessagingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessagingService messagingService;

    public MessageController(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @PostMapping("/publish")
    public String publish(@RequestBody MessageRequest request) {
        messagingService.publish(request.destination(), request.message());
        return "Message sent";
    }
}
