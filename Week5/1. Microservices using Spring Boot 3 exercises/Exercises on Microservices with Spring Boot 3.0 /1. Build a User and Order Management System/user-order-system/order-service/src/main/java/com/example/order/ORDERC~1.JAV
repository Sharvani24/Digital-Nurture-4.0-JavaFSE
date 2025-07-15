package com.example.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserClient userClient;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getOrderWithUser(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        User user = userClient.getUserById(order.getUserId());
        return Map.of("order", order, "user", user);
    }
}
