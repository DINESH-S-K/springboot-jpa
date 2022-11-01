package com.c1x.onetomanymapping.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category")
    private String category;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private double productPrice;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "product_rating")
    private double productRating;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Cart cart;

    public Item(String category, String productName, double productPrice, int quantity, double productRating, Cart cart) {
        this.category = category;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.productRating = productRating;
    }
}

