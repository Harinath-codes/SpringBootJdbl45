package com.ecom.store.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userTb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    private String name;
    private String address;
    private String creditCard;
    public User(String name,String address,String creditCard){
        this.name = name;
        this.address = address;
        this.creditCard = creditCard;
    }
    public User(){}
}
