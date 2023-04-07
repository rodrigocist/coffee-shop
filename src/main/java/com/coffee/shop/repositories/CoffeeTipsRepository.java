package com.coffee.shop.repositories;

import com.coffee.shop.models.CoffeeTips;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeTipsRepository extends JpaRepository<CoffeeTips,Long> {
}
