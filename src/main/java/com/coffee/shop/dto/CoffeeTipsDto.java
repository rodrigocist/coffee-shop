package com.coffee.shop.dto;

import lombok.Data;

@Data
public class CoffeeTipsDto {
    private Long id;
    private String name;
    private String description;
    private String image;
    private boolean active;
}
