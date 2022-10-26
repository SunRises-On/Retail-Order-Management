package com.example.gift.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//word "order" is a reserved word, changed to "orders"
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //changed
  //  @Column(name = "order_id")
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



    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = User.class
    )
    @JoinColumn( name = "user_id",
            referencedColumnName = "id",
            nullable = false)
    private User user;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "orders",
            cascade = CascadeType.ALL,
            targetEntity = OrderDetails.class
    )
    private List<OrderDetails> orderDetails = new ArrayList<>();
    public Order(){}
    public Order(Long id, String countryOrRegion, String firstName, String lastName, String address, String apartmentOrSuite, String city, String state, String zipCode, String phone) {
        this.id = id;
        this.countryOrRegion = countryOrRegion;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.apartmentOrSuite = apartmentOrSuite;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryOrRegion() {
        return countryOrRegion;
    }

    public void setCountryOrRegion(String countryOrRegion) {
        this.countryOrRegion = countryOrRegion;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApartmentOrSuite() {
        return apartmentOrSuite;
    }

    public void setApartmentOrSuite(String apartmentOrSuite) {
        this.apartmentOrSuite = apartmentOrSuite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
