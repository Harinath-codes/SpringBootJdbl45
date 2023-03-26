package com.ecom.store.dto;

import lombok.Data;

import java.util.List;

import com.ecom.store.model.User;

@Data
public class OrderDto {


    private List<Integer> cartIDList;

    private User user;

}
