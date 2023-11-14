package com.nexign.CoffeShop.controllers;

import com.nexign.CoffeShop.dto.OrderRequest;
import com.nexign.CoffeShop.entities.OrderEntity;
import com.nexign.CoffeShop.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.addOrder(orderRequest));
    }
}
