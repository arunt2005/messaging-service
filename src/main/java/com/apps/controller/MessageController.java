package com.apps.controller;

import com.apps.dto.ApiResponse;
import com.apps.dto.PublishMessageRequest;
import com.apps.messaging.MessagePublisher;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessagePublisher publisher;

    public MessageController(MessagePublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/publish")
    public ResponseEntity<ApiResponse> publish(
            @Valid @RequestBody PublishMessageRequest request) {

        try {
            for (int i = 0; i < 5; i++) {
                publisher.publish(request.getMessage());
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(
                new ApiResponse("SUCCESS", "Message published successfully")
        );
    }
}
