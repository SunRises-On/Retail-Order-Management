package com.example.gift.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table( name = "orderDetails")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Integer product_id;

  //  @NotBlank
  //  private String order_id;

    @NotBlank
    private Integer quantityOrdered;

    @NotBlank
    private Integer priceEach;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Order.class
    )
    @JoinColumn( name = "orders_id",
            referencedColumnName = "id",
            nullable = false)
    private Order orders;


    public OrderDetails(){}

    public OrderDetails(Long id, Integer product_id, Integer quantityOrdered, Integer priceEach) {
        this.id = id;
        this.product_id = product_id;
   //     this.order_id = order_id;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Integer getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(Integer priceEach) {
        this.priceEach = priceEach;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Order getOrder() {
        return orders;
    }

    public void setOrder(Order orders) {
        this.orders = orders;
    }


}
