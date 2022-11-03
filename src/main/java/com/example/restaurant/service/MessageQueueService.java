package com.example.restaurant.service;

public interface MessageQueueService {
    void addMessage(String message);

    String getMessage();
}
