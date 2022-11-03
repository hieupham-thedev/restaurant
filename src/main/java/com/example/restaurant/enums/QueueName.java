package com.example.restaurant.enums;

import lombok.Getter;

@Getter
public enum QueueName {
    ORDER_CREATED_QUEUE("order-created-queue");

    private final String name;

    QueueName(String name) {
        this.name = name;
    }

}
