package com.example.restaurant.service.impl;

import com.example.restaurant.dto.OrderDTO;
import com.example.restaurant.service.MessageQueueService;
import com.example.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    @Qualifier("orderQueueService")
    private MessageQueueService orderQueueService;

    @Override
    public List<OrderDTO> getAll() {
//        Iterable<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOs = new ArrayList<>();
//        orders.forEach(order -> {
//            OrderDTO orderDTO = new OrderDTO();
//            BeanUtils.copyProperties(order, orderDTO);
//            orderDTOs.add(orderDTO);
//        });
        return orderDTOs;
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
//        BeanUtils.copyProperties(orderDTO, order);
//        UUID uuid = UUID.randomUUID();
//        order.setId(uuid.toString());
//        orderRepository.save(order);
//        orderDTO.setId(order.getId());
        return null;
    }

    @Override
    public OrderDTO saveOrderString(OrderDTO orderDTO) {
        UUID uuid = UUID.randomUUID();
        orderDTO.setId(uuid.toString());
        orderQueueService.addMessage(orderDTO.toString());
        return orderDTO;
    }
}
