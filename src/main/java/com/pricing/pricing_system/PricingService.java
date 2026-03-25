package com.pricing.pricing_system;
import org.springframework.stereotype.Service;
@Service
public class PricingService {

    public double calculateSuggestedPrice(Product product, int recentSalesCount) {
        double demandFactor = 1.0;
        double inventoryFactor = 1.0;

        // Demand-based adjustment
        if (recentSalesCount > 5) {
            demandFactor = 1.2; // high demand → +20%
        } else if (recentSalesCount < 2) {
            demandFactor = 0.9; // low demand → -10%
        }

        // Inventory-based adjustment
        if (product.getInventory() <= 2) {
            inventoryFactor = 1.3; // low inventory → +30%
        } else if (product.getInventory() >= 10) {
            inventoryFactor = 0.8; // high inventory → -20%
        }

        return product.getBasePrice() * demandFactor * inventoryFactor;
    }

    public double calculateSuggestedPrice(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateSuggestedPrice'");
    }
}
