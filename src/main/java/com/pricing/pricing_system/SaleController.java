package com.pricing.pricing_system;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleRepository saleRepo;
    @Autowired
    private ProductRepository productRepo;

    @PostMapping
    public Sale logSale(@RequestParam Long productId, @RequestParam int quantity) {
        Product product = productRepo.findById(productId).orElseThrow();
        product.setInventory(product.getInventory() - quantity);
        productRepo.save(product);

        Sale sale = new Sale();
        sale.setProductId(productId);
        sale.setQuantity(quantity);
        return saleRepo.save(sale);
    }

    @GetMapping("/analytics")
    public List<Sale> getSalesTrend() {
        return saleRepo.findAll();
    }
}
