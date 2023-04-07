package com.coffee.shop.services.impl;

import com.coffee.shop.dto.CoffeePlacesDto;
import com.coffee.shop.models.CoffeePlaces;
import com.coffee.shop.repositories.CoffeePlacesRepository;
import com.coffee.shop.services.CoffeePlacesService;
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
public class CoffeePlacesServiceImpl implements CoffeePlacesService {

    @Autowired
    CoffeePlacesRepository coffeePlacesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<String> save(CoffeePlacesDto coffeePlacesDto) {
        try{
            CoffeePlaces coffeePlaces = modelMapper.map(coffeePlacesDto, CoffeePlaces.class);
            coffeePlacesRepository.save(coffeePlaces);
            return new ResponseEntity("save successful", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error saving coffee place", e);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CoffeePlacesDto getById(Long id) {
        CoffeePlacesDto coffeePlacesDto = new CoffeePlacesDto();
        try{
            Optional<CoffeePlaces> coffeePlaces = coffeePlacesRepository.findById(id);
            coffeePlaces.orElseThrow(() -> new Exception("Data not found"));
            if(coffeePlaces.isPresent()){
                coffeePlacesDto = modelMapper.map(coffeePlaces.get(), CoffeePlacesDto.class);
            }
        } catch (Exception e) {
            log.error("Error get coffee place ", e);
        }
        return coffeePlacesDto;
    }


    @Override
    public List<CoffeePlacesDto> getAll() {
        List<CoffeePlacesDto> coffeePlacesDto = new ArrayList<>();
        try{
            List<CoffeePlaces> coffeePlaces = coffeePlacesRepository.findAll();
            coffeePlacesDto = coffeePlaces.stream()
                    .map(coffee -> modelMapper.map(coffee,CoffeePlacesDto.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error get all coffee places ", e);
        }
        return coffeePlacesDto;
    }

    @Override
    public boolean delete(Long id) {
        try {
            coffeePlacesRepository.deleteById(id);
            return true;
        }catch (Exception e){
            log.error("Error to delete coffee place", e);
            return false;
        }
    }
}
