package com.example.restaurant.schedule;

import com.example.restaurant.dto.OrderDTO;
import com.example.restaurant.service.MessageQueueService;
import com.example.restaurant.service.RedisCacheService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class OrderProcessScheduler {

    private static final Logger logger = LoggerFactory.getLogger(OrderProcessScheduler.class);

    @Autowired
    @Qualifier("orderQueueService")
    private MessageQueueService orderQueueService;

    @Autowired
    private RedisCacheService redisCacheService;

    @Scheduled(cron = "0 * * ? * *")
    private void processOrder() {
        logger.info("Start processing order...");
        try {
            String messageString = orderQueueService.getMessage();
            if (messageString == null) {
                logger.info("No message in queue");
                return;
            }
            logger.info("Got message from queue: {}", messageString);
            ObjectMapper mapper = new ObjectMapper();
            OrderDTO orderDTO = mapper.readValue(messageString, OrderDTO.class);
            String key = redisCacheService.generateOrderStringKey(orderDTO.getRestaurantCode(), orderDTO.getId());
            redisCacheService.setStringValueForKey(key, orderDTO.toString(), 3600);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.info("End processing order");
        }
    }
}
