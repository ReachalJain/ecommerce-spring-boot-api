package com.ecommerce.ecommerce_api.controller;

import com.ecommerce.ecommerce_api.model.Product;
import com.ecommerce.ecommerce_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    // ✅ Saare products lao
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ✅ Ek product lao by ID
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productRepository.findById(id).orElse(null);
    }
    // ✅ Category wise products
    @GetMapping("/products/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return productRepository.findByCategory(category);
    }
}