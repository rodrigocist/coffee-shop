package com.coffee.shop.controllers;

import com.coffee.shop.dto.CoffeeTipsDto;
import com.coffee.shop.services.CoffeeTipsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/coffeetips")
public class CoffeeTipsController {

    @Autowired
    CoffeeTipsService coffeeTipsService;

    @GetMapping
    public List<CoffeeTipsDto> getAll(){
        return coffeeTipsService.getAll();
    }

    @GetMapping("{id}")
    public CoffeeTipsDto getById(@PathVariable("id") Long id){
        return coffeeTipsService.getById(id);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CoffeeTipsDto coffeeTipsDto){
        return new ResponseEntity(coffeeTipsService.save(coffeeTipsDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody CoffeeTipsDto coffeeTipsDto){
        return new ResponseEntity(coffeeTipsService.save(coffeeTipsDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return new ResponseEntity(coffeeTipsService.delete(id), HttpStatus.ACCEPTED);
    }

}
