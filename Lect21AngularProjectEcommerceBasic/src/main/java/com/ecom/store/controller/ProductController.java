package com.ecom.store.controller;

import com.ecom.store.dto.CartResponse;
import com.ecom.store.exception.RecordNotFound;
import com.ecom.store.model.Cart;
import com.ecom.store.model.Product;
import com.ecom.store.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
//@CrossOrigin(origins = "http://localhost:4200")


public class ProductController {
// TODO: Use the mapping products to add an API endpoint to fetch the products from the ProductRepository


    @Autowired
    private ProductService productService;


    @GetMapping
    public List<Product> findAllProduct(){
        List<Product> allProduct = productService.findAllProduct();
        return allProduct;
    }

    @GetMapping("/{productID}")
    public Product findAllProduct(@PathVariable("productID") Integer productID) throws RecordNotFound {
        Product product = productService.findProductByID(productID);
        return product;
    }


    @GetMapping("/cart/{userID}")
    public List<CartResponse> findAllProductFromCartByUserID(@PathVariable("userID")Integer userID){
        List<CartResponse> allProduct =
                productService.findAllProductFromCartByUserID(userID);
        return allProduct;
    }

    @PostMapping("/add-to-cart")
    public Cart productAddedToCart(@RequestBody Cart cart) throws RecordNotFound {
       return this.productService.addProductToCart(cart);
    }

    @PutMapping("update-to-cart")
    public Cart updateAddedToCart(@RequestBody Cart cart) throws RecordNotFound {
      return  this.productService.updateCart(cart);
    }




}
