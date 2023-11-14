package com.nexign.CoffeShop.repositories;

import com.nexign.CoffeShop.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}