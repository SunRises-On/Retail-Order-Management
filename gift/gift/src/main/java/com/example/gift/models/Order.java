package com.example.gift.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //changed
    @Column(name = "order_id")
    private Long id;

    @NotNull
    @Size(max = 50)
    private String countryOrRegion;

    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Size(max = 50)
    private String lastName;

    @NotNull
    @Size( max = 50)
    private String address;

    //optional
    @Size( max = 25)
    private String apartmentOrSuite;

    @NotNull
    @Size(max = 50)
    private String city;


    @Size(max = 50)
    private String state;

    @NotNull
    @Size(max = 25)
    private String zipCode;

    @NotNull
    @Size(max = 10)
    private String phone;

    @OneToMany(
           fetch = FetchType.LAZY
    )
    @JoinTable ( name = "ticket",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products =new HashSet<>();

    


}
