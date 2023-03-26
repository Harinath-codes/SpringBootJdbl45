package com.ecom.store.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
// TODO: Add the details of the product class


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    private String title;
    private String description;
    private double price;
    private String imageURL;

    public Product(){}
     public Product(String title,String description,double price,String imageURL){
     this.title =title;
     this.description = description;
     this.price = price;
     this.imageURL = imageURL;
 }
}
