package com.coffee.shop.controllers;

import com.coffee.shop.dto.CoffeePlacesDto;
import com.coffee.shop.services.CoffeePlacesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/coffeeplaces")
public class CoffeePlacesController {
    @Autowired
    CoffeePlacesService coffeePlacesService;

    @GetMapping
    public List<CoffeePlacesDto> getAll(){
        return coffeePlacesService.getAll();
    }

    @GetMapping("{id}")
    public CoffeePlacesDto getById(@PathVariable("id") Long id){
        return coffeePlacesService.getById(id);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CoffeePlacesDto coffeePlacesDto){
        return new ResponseEntity(coffeePlacesService.save(coffeePlacesDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody CoffeePlacesDto coffeePlacesDto){
        return new ResponseEntity(coffeePlacesService.save(coffeePlacesDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return new ResponseEntity(coffeePlacesService.delete(id), HttpStatus.ACCEPTED);
    }
}
