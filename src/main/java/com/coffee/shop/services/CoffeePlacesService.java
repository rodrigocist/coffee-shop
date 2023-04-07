package com.coffee.shop.services;


import com.coffee.shop.dto.CoffeePlacesDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CoffeePlacesService {

    ResponseEntity<String> save(CoffeePlacesDto coffeePlacesDto);

    CoffeePlacesDto getById(Long id);

    List<CoffeePlacesDto> getAll();

    boolean delete(Long id);

}
