package com.coffee.shop.services.impl;

import com.coffee.shop.dto.CoffeeTipsDto;
import com.coffee.shop.models.CoffeeTips;
import com.coffee.shop.repositories.CoffeeTipsRepository;
import com.coffee.shop.services.CoffeeTipsService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CoffeeTipsServiceImpl implements CoffeeTipsService {

    @Autowired
    CoffeeTipsRepository coffeeTipsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<String> save(CoffeeTipsDto coffeeTipsDto) {
        try{
                CoffeeTips coffeeTips = modelMapper.map(coffeeTipsDto, CoffeeTips.class);
                coffeeTipsRepository.save(coffeeTips);
            return new ResponseEntity("save successful", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error saving coffee tips", e);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CoffeeTipsDto getById(Long id) {
        CoffeeTipsDto coffeeTipsDto = new CoffeeTipsDto();
        try{
            Optional<CoffeeTips> coffeeTips = coffeeTipsRepository.findById(id);
            coffeeTips.orElseThrow(() -> new Exception("Data not found"));

            if(coffeeTips.isPresent()){
                coffeeTipsDto = modelMapper.map(coffeeTips.get(), CoffeeTipsDto.class);
            }

         } catch (Exception e) {
            log.error("Error get coffee tips ", e);
        }
        return coffeeTipsDto;
    }

    @Override
    public List<CoffeeTipsDto> getAll() {
        List<CoffeeTipsDto> coffeesTipsDto = new ArrayList<>();
        try{
            List<CoffeeTips> coffeesTips = coffeeTipsRepository.findAll();
            coffeesTipsDto = coffeesTips.stream()
                    .map(coffee -> modelMapper.map(coffee,CoffeeTipsDto.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error get all coffee tips ", e);
        }
        return coffeesTipsDto;
    }

    @Override
    public boolean delete(Long id) {
        try {
            coffeeTipsRepository.deleteById(id);
            return true;
        }catch (Exception e){
            log.error("Error al eliminar", e);
            return false;
        }
    }

}
