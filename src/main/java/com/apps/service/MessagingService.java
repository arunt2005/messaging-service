package com.apps.service;

public interface MessagingService {

    void publish(String destination, String message);

    void subscribe(String destination);
}
