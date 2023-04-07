package com.coffee.shop.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="coffee_tips")
public class CoffeeTips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;
    private boolean active;
}

