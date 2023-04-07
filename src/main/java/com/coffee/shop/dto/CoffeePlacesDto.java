package com.coffee.shop.dto;

import lombok.Data;

@Data
public class CoffeePlacesDto {
    private Long id;
    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private boolean active;
}
