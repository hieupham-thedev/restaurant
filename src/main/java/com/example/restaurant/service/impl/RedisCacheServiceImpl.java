package com.example.restaurant.service.impl;

import com.example.restaurant.consts.RestaurantConst;
import com.example.restaurant.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void setStringValueForKey(String key, String value, long ttl) {
        stringRedisTemplate.boundValueOps(key).set(value, ttl, TimeUnit.SECONDS);
    }

    @Override
    public String getStringValueForKey(String key) {
        return stringRedisTemplate.boundValueOps(key).get();
    }

    @Override
    public String generateOrderStringKey(String restaurantCode, String id) {
        return String.format(RestaurantConst.RESTAURANT_ORDER_CACHE_KEY, restaurantCode, id);
    }
}
