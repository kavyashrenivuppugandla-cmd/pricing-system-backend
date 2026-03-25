package com.pricing.pricing_system;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    long countByProductId(Long productId);
}

