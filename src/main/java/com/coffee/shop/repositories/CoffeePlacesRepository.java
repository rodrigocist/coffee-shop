package com.coffee.shop.repositories;

import com.coffee.shop.models.CoffeePlaces;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeePlacesRepository extends JpaRepository<CoffeePlaces, Long> {
}
