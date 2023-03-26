package com.ecom.store.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductOrdered {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    private Integer userID;
    private Integer productID;
    private Integer quantity;

    @ManyToOne
    private Orders orders;
}
