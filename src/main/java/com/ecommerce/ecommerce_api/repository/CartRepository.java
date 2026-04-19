package com.ecommerce.ecommerce_api.repository;

import com.ecommerce.ecommerce_api.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByUserId(int userId);

    Cart findByUserIdAndProductId(int userId, int productId);

    @Transactional
    void deleteByUserIdAndProductId(int userId, int productId);
}