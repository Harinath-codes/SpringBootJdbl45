package com.ecom.store.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.store.model.Cart;
import com.ecom.store.model.Product;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> findAllByUserIDAndActive(Integer userID,boolean active);

    Cart findByUserIDAndProductID(Integer userID, Integer productId);

}
