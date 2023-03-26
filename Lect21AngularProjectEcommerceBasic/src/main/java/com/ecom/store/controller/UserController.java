package com.ecom.store.controller;


import com.ecom.store.model.User;
import com.ecom.store.repository.UserRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
//@CrossOrigin(origins = "http://localhost:4200")

public class UserController {

    @Autowired
    private UserRespository userRespository;

    @GetMapping
    public List<User> findAllUser(){
        return this.userRespository.findAll();
    }
}
