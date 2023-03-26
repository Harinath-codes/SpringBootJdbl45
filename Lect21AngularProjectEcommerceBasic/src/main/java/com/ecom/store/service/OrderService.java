package com.ecom.store.service;

import com.ecom.store.dto.OrderDto;
import com.ecom.store.model.Cart;
import com.ecom.store.model.Orders;
import com.ecom.store.model.ProductOrdered;
import com.ecom.store.model.User;
import com.ecom.store.repository.CartRepository;
import com.ecom.store.repository.OrderRepository;
import com.ecom.store.repository.ProductOrderedRepo;
import com.ecom.store.repository.UserRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRespository userRespository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductOrderedRepo productOrderedRepo;

    public Orders addorder(OrderDto orderDto) {
        User orderDtoUser = orderDto.getUser();
        User user = userRespository.save(orderDtoUser);

        Orders orders = new Orders();

        orders.setUserID(user.getID());
        Orders save1 = orderRepository.save(orders);

        List<Integer> cartIDList = orderDto.getCartIDList();

        List<Integer> cartList = new ArrayList<>();
        for(Integer cartId:cartIDList){
            Optional<Cart> optionalCart = cartRepository.findById(cartId);
            if(optionalCart.isPresent()){
                Cart updateCart = optionalCart.get();

                //creating product order and having a mapping of many to one
                ProductOrdered productOrdered = new ProductOrdered();
                productOrdered.setOrders(save1);
                productOrdered.setUserID(user.getID());
                productOrdered.setProductID(productOrdered.getProductID());
                productOrdered.setQuantity(updateCart.getQuantity());
                ProductOrdered save = productOrderedRepo.save(productOrdered);
                cartRepository.delete(updateCart);

            }
        }




//        S save = this.orderRepository.save(orderDto);

        return orders;
    }
}
