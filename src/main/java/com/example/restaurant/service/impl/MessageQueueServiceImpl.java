package com.example.restaurant.service.impl;

import com.example.restaurant.service.MessageQueueService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public abstract class MessageQueueServiceImpl implements MessageQueueService {

    @Autowired
    private Connection connection;

    protected abstract String getQueue();

    private void queueDeclare(Channel channel) throws IOException {
        channel.queueDeclare(getQueue(), true, false, false, null);
    }

    @Override
    public void addMessage(String message) {
        Channel channel = null;
        try {
            channel = connection.createChannel();
            queueDeclare(channel);
            channel.basicPublish("", getQueue(), null, message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getMessage() {
        Channel channel = null;
        String message = null;
        try {
            channel = connection.createChannel();
            queueDeclare(channel);
            channel.basicQos(1);
            GetResponse response = channel.basicGet(getQueue(), true);

            if (response != null) {
                message = new String(response.getBody(), StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return message;
    }
}
