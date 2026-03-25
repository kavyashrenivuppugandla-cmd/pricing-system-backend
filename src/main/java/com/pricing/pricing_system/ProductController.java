package com.pricing.pricing_system;


// import java.util.List;

// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/products")
// @CrossOrigin
// public class ProductController {

//     private final ProductService service;

//     public ProductController(ProductService service) {
//         this.service = service;
//     }

//     @GetMapping
//     public List<Product> getProducts() {
//         return service.getAllProducts();
//     }

//     @PostMapping
//     public Product addProduct(@RequestBody Product product) {
//         return service.addProduct(product);
//     }
// }

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private SaleRepository saleRepo;
    @Autowired
    private PricingService pricingService;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        List<Product> products = productRepo.findAll();
        for (Product p : products) {
            int recentSales = (int) saleRepo.countByProductId(p.getId());
            double suggested = pricingService.calculateSuggestedPrice(p, recentSales);
            p.setSuggestedPrice(suggested);
        }
        return products;
    }
    @PutMapping("/{id}/inventory")
public Product updateInventory(@PathVariable Long id, @RequestParam int inventory) {
    Product product = productRepo.findById(id).orElseThrow();
    product.setInventory(inventory);
    productRepo.save(product);

    // Recalculate suggested price using your PricingService
    int recentSales = (int) saleRepo.countByProductId(product.getId());
    double suggested = pricingService.calculateSuggestedPrice(product, recentSales);
    product.setSuggestedPrice(suggested);

    return product;
}

}
