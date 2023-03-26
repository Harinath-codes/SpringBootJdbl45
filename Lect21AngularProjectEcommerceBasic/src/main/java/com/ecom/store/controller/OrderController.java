package com.ecom.store.controller;

import com.ecom.store.dto.OrderDto;
import com.ecom.store.model.Orders;
import com.ecom.store.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
//@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
// TODO: Use the mapping submit to add an API endpoint to fetch the products from the OrderRepository


    @Autowired
    private OrderService orderService;


    @PostMapping("/add")
    public Orders orderProduct(@RequestBody OrderDto orderDto){
        Orders addorder = orderService.addorder(orderDto);
        return addorder;

//        return null;
    }



}
