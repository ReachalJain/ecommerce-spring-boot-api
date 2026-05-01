package com.ecommerce.ecommerce_api.controller;

import com.ecommerce.ecommerce_api.model.Cart;
import com.ecommerce.ecommerce_api.model.CartResponse;
import com.ecommerce.ecommerce_api.model.Product;
import com.ecommerce.ecommerce_api.repository.CartRepository;
import com.ecommerce.ecommerce_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;


    @GetMapping("/{userId}")
    public List<CartResponse> getCart(@PathVariable int userId) {
        List<Cart> cartItems = cartRepository.findByUserId(userId);
        List<CartResponse> response = new ArrayList<>();

        for (Cart cart : cartItems) {
            Product product = productRepository.findById(cart.getProductId()).orElse(null);
            if (product != null) {
                response.add(new CartResponse(
                        cart.getCartId(),
                        cart.getUserId(),
                        cart.getProductId(),
                        cart.getQuantity(),
                        product.getName(),
                        product.getPrice(),
                        product.getImageUrl(),
                        product.getDescription()
                ));
            }
        }
        return response;
    }


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