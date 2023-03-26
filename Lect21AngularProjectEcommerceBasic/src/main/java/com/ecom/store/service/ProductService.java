package com.ecom.store.service;

import com.ecom.store.dto.CartResponse;
import com.ecom.store.exception.RecordNotFound;
import com.ecom.store.model.Cart;
import com.ecom.store.model.Product;
import com.ecom.store.repository.CartRepository;
import com.ecom.store.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public List<CartResponse> findAllProductFromCartByUserID(Integer userID) {
        List<Cart> allByUserID = cartRepository.findAllByUserIDAndActive(userID, true);

        List<CartResponse> productList = new ArrayList<>();

        for (Cart cart : allByUserID) {
            Optional<Product> optionalProduct = productRepository.findById(cart.getProductID());
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                CartResponse cartResponse = new CartResponse(product, cart);
                productList.add(cartResponse);

            }

        }
        return productList;
    }

    public Cart addProductToCart(Cart cart) throws RecordNotFound {
        Cart response = cartRepository.findByUserIDAndProductID(cart.getUserID(), cart.getProductID());

        if (response == null) {
            return cartRepository.save(cart);
        }else {
            response.setQuantity(response.getQuantity()+cart.getQuantity());
            return cartRepository.save(response);

        }
    }

    public Product findProductByID(Integer productID) throws RecordNotFound {
        Optional<Product> optionalProduct = this.productRepository.findById(productID);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new RecordNotFound("Product not found by ID" + productID);
    }

    public Cart updateCart(Cart cart) throws RecordNotFound {
        Cart optionCart = cartRepository.findByUserIDAndProductID(cart.getUserID(),cart.getProductID());

        if (optionCart==null) {
            throw new RecordNotFound("Cart not exists by user ID and product ID" + cart.getUserID() + "product ID" + cart.getProductID());
        }

        if(cart.getQuantity()==0){
            cart.setActive(false);
            Integer id = optionCart.getID();
            cart.setID(id);
            cartRepository.delete(cart);
            return cart;
        }else return cartRepository.save(cart);


    }
}
