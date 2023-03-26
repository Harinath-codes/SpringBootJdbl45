package com.jdbl45.wallet.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody UserCreateRequest userCreateRequest) throws JsonProcessingException {
        return userService.create(userCreateRequest.to());
    }

    @GetMapping("/user")
    public User getUser(@RequestParam("id") int id){
        return userService.get(id);
    }
}