package com.springdatajpa.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    //    Added
    private String state1;
    private String country1;
    private String zipCode1;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
}
