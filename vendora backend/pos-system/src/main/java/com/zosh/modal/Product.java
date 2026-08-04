//package com.zosh.modal;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "products")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(unique = true, nullable = false)
//    private String sku; // Stock Keeping Unit
//
//    private String description;
//
//    @Column(nullable = false)
//    private Double mrp; // Maximum Retail Price
//
//    @Column(nullable = false)
//    private Double sellingPrice; // Actual sale price
//
//    private String brand;
//
//    private String image;
//
//    @ManyToOne
//    private Category category;
//
//    @ManyToOne
//    @JoinColumn(name = "store_id", nullable = false)
//    private Store store;
//
//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;
//
//    @PrePersist
//    protected void onCreate() {
//        createdAt = updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        updatedAt = LocalDateTime.now();
//    }
//}
package com.zosh.modal;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable =false)
    private String sku; // Stock Keeping Unit

    private String description;

    @Column(nullable = false)
    private Double mrp; // Maximum Retail Price

    @Column(nullable = false)
    private Double sellingPrice; // Actual sale price

    private String brand;

    private String image;

    @ManyToOne
    private Category category;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // No-argument constructor
    public Product() {
    }

    // All-arguments constructor
    public Product(Long id, String name, String sku, String description,
                   Double mrp, Double sellingPrice, String brand,
                   String image, Category category, Store store,
                   LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.description = description;
        this.mrp = mrp;
        this.sellingPrice = sellingPrice;
        this.brand = brand;
        this.image = image;
        this.category = category;
        this.store = store;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMrp() {
        return mrp;
    }

    public void setMrp(Double mrp) {
        this.mrp = mrp;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}