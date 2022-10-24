package com.example.gift.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table( name = "product" ,
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "productName"),
                @UniqueConstraint(columnNames = "img")
        })

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "product_id")
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String productName;

    @NotBlank
    private Integer quantity;

    @NotBlank
    private Integer buyPrice;

    private String img;


    public Product(){

    }

    public Product(Long id, String productName, Integer quantity, Integer buyPrice, String img) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}

