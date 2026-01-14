package com.apps.dto;

import jakarta.validation.constraints.NotBlank;

public class PublishMessageRequest {

    @NotBlank(message = "message must not be blank")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
