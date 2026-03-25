
package com.pricing.pricing_system;

import jakarta.persistence.*;

// @Entity
// public class Product {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     private double basePrice;

//     private int inventory;

//     public Product(){}

//     public Long getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

//     public double getBasePrice() {
//         return basePrice;
//     }

//     public int getInventory() {
//         return inventory;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public void setBasePrice(double basePrice) {
//         this.basePrice = basePrice;
//     }

//     public void setInventory(int inventory) {
//         this.inventory = inventory;
//     }
// }
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double basePrice;
    private int inventory;
    

    @Transient
    private double suggestedPrice;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }

    public int getInventory() { return inventory; }
    public void setInventory(int inventory) { this.inventory = inventory; }

    public double getSuggestedPrice() { return suggestedPrice; }
    public void setSuggestedPrice(double suggestedPrice) { this.suggestedPrice = suggestedPrice; }
}
