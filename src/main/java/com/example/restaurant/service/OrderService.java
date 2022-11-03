package com.example.restaurant.service;

import com.example.restaurant.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAll();

    OrderDTO save(OrderDTO orderDTO);

    OrderDTO saveOrderString(OrderDTO orderDTO);

}
