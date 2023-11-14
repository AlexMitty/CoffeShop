package com.nexign.CoffeShop.controllers;

import com.nexign.CoffeShop.entities.ProductEntity;
import com.nexign.CoffeShop.services.ProductService;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")

public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public @NotNull Iterable<ProductEntity> getProducts() {
        return productService.getAllProducts();
    }
}
