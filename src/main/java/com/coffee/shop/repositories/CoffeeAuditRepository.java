package com.coffee.shop.repositories;

import com.coffee.shop.models.CoffeeAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeAuditRepository extends JpaRepository<CoffeeAudit, Long> {
}
