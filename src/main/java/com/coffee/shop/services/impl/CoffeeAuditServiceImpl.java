package com.coffee.shop.services.impl;

import com.coffee.shop.dto.CoffeeAuditDto;
import com.coffee.shop.dto.CoffeePlacesDto;
import com.coffee.shop.models.CoffeeAudit;
import com.coffee.shop.models.CoffeePlaces;
import com.coffee.shop.repositories.CoffeeAuditRepository;
import com.coffee.shop.repositories.CoffeePlacesRepository;
import com.coffee.shop.services.CoffeeAuditService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CoffeeAuditServiceImpl implements CoffeeAuditService {

    @Autowired
    CoffeeAuditRepository coffeeAuditRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<String> save(CoffeeAuditDto coffeeAuditDto) {
        try{
            CoffeeAudit coffeeAudit = modelMapper.map(coffeeAuditDto, CoffeeAudit.class);
            coffeeAuditRepository.save(coffeeAudit);
            return new ResponseEntity("save successful", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error saving audit", e);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
