package com.coffee.shop.services;

import com.coffee.shop.dto.CoffeeTipsDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CoffeeTipsService {

    ResponseEntity<String> save(CoffeeTipsDto coffeeTipsDto);

    CoffeeTipsDto getById(Long id);

    List<CoffeeTipsDto> getAll();

    boolean delete(Long id);
}
