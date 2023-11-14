package com.nexign.CoffeShop.repositories;

import com.nexign.CoffeShop.entities.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity, Long> {
}