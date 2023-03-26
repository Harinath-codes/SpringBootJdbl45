package com.ecom.store.dto;

import com.ecom.store.model.Cart;
import com.ecom.store.model.Product;

import lombok.Data;

@Data
public class CartResponse {

    private Cart cart;
    private Product product;

    public CartResponse(Product product, Cart cart) {
        this.cart =cart;
        this.product =product;
    }
}
