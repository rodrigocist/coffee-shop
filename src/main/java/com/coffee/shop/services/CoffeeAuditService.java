package com.coffee.shop.services;

import com.coffee.shop.dto.CoffeeAuditDto;
import org.springframework.http.ResponseEntity;

public interface CoffeeAuditService {

    ResponseEntity<String> save(CoffeeAuditDto coffeeAuditDto);
}
