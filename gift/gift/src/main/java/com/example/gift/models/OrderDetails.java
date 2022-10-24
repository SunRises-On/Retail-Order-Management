package com.example.gift.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table( name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String product_id;

    @NotBlank
    private String order_id;

    @NotBlank
    private Integer quantityOrdered;

    @NotBlank
    private Integer priceEach;



}
