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

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Order.class
    )
    @JoinColumn( name = "orders_id",
            referencedColumnName = "id",
            nullable = false)
    private Order orders;
    public OrderDetails(){}

    public OrderDetails(Long id, String product_id, String order_id, Integer quantityOrdered, Integer priceEach) {
        this.id = id;
        this.product_id = product_id;
        this.order_id = order_id;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
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

    public Order getOrder() {
        return orders;
    }

    public void setOrder(Order order) {
        this.orders = order;
    }
}
