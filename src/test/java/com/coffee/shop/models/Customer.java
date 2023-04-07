package com.coffee.shop.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

}
