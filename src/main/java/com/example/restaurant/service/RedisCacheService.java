package com.example.restaurant.service;

public interface RedisCacheService {
    void setStringValueForKey(String key, String value, long ttl);

    String getStringValueForKey(String key);

    String generateOrderStringKey(String restaurantCode, String id);
}
