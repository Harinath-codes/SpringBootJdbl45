package com.ecom.store.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Orders {
//TODO: Add the details of the order class

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    private Integer userID;
    private String status="CREATED";


}
