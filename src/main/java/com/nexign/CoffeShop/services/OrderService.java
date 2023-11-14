package com.nexign.CoffeShop.services;

import com.nexign.CoffeShop.dto.OrderItemRequest;
import com.nexign.CoffeShop.dto.OrderRequest;
import com.nexign.CoffeShop.entities.OrderEntity;
import com.nexign.CoffeShop.entities.OrderItemEntity;
import com.nexign.CoffeShop.repositories.OrderItemEntityRepository;
import com.nexign.CoffeShop.repositories.OrderRepository;
import com.nexign.CoffeShop.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemEntityRepository orderItemEntityRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository  productRepository, OrderItemEntityRepository orderItemEntityRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderItemEntityRepository = orderItemEntityRepository;
    }

    public OrderEntity addOrder(OrderRequest orderRequest) {

        OrderEntity orderEntity = new OrderEntity();

        List<OrderItemEntity> orderItemEntities = new ArrayList<>();
        double totalPrice = 0.0;

        for (OrderItemRequest item : orderRequest.getItems()) {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setOrder(orderEntity);
            orderItemEntity.setProduct(productRepository.findById(item.getProductId()).get());
            orderItemEntity.setQuantity(item.getQuantity());
            orderItemEntities.add(orderItemEntity);
            totalPrice += orderItemEntity.getProduct().getPrice() * item.getQuantity();
        }
        orderEntity.setCreated(LocalDateTime.now());
        orderEntity.setTotalPrice(totalPrice);


        orderItemEntityRepository.saveAll(orderItemEntities);
        return orderRepository.save(orderEntity);
    }


}
