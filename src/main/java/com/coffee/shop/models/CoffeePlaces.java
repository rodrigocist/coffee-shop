package com.coffee.shop.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="coffee_places")
public class CoffeePlaces {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private boolean active;
}
