package com.yeowon.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
    private int quantity;

    public Product(){}
    public Product(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
