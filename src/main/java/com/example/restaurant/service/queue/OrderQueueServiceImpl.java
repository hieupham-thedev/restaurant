package com.example.restaurant.service.queue;

import com.example.restaurant.enums.QueueName;
import com.example.restaurant.service.impl.MessageQueueServiceImpl;
import org.springframework.stereotype.Service;

@Service("orderQueueService")
public class OrderQueueServiceImpl extends MessageQueueServiceImpl {
    @Override
    protected String getQueue() {
        return QueueName.ORDER_CREATED_QUEUE.getName();
    }
}
