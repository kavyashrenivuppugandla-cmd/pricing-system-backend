package com.pricing.pricing_system;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pricing")
@CrossOrigin
public class PricingController {

    private final PricingService service;

    public PricingController(PricingService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public double getSuggestedPrice(@PathVariable Long id) {
        return service.calculateSuggestedPrice(id);
    }
}