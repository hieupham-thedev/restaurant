package com.example.restaurant.controller;

import com.example.restaurant.dto.OrderDTO;
import com.example.restaurant.schedule.OrderProcessScheduler;
import com.example.restaurant.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity getAllOrders() {
        List<OrderDTO> orderDTOs = orderService.getAll();
        return ResponseEntity.ok(orderDTOs);
    }

    @PostMapping("/orders")
    public ResponseEntity createOrder(@RequestBody OrderDTO orderDTO) {
//        OrderDTO responseOrderDTO = orderService.save(orderDTO);
        OrderDTO responseOrderDTO = orderService.saveOrderString(orderDTO);
        return ResponseEntity.ok(responseOrderDTO);
    }
}
