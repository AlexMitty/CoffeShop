package com.nexign.CoffeShop.services;

import com.nexign.CoffeShop.entities.ProductEntity;
import com.nexign.CoffeShop.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    private final ProductRepository  productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}
