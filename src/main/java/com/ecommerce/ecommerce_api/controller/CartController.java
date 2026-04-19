package com.ecommerce.ecommerce_api.controller;

import com.ecommerce.ecommerce_api.model.Cart;
import com.ecommerce.ecommerce_api.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartRepository cartRepository;

    // ✅ User ka cart dekho
    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable int userId) {
        return cartRepository.findByUserId(userId);
    }

    // ✅ Cart mein add karo
    @PostMapping("/add")
    public String addToCart(@RequestBody Cart cart) {
        Cart existing = cartRepository.findByUserIdAndProductId(
                cart.getUserId(),
                cart.getProductId()
        );
        if (existing != null) {
            return "Product already in cart!";
        }
        cartRepository.save(cart);
        return "Product added to cart!";
    }

    // ✅ Cart se hatao - @Transactional add kiya
    @Transactional
    @DeleteMapping("/remove/{userId}/{productId}")
    public String removeFromCart(
            @PathVariable int userId,
            @PathVariable int productId
    ) {
        cartRepository.deleteByUserIdAndProductId(userId, productId);
        return "Product removed from cart!";
    }
}