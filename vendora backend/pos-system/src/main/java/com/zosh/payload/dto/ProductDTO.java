package com.zosh.payload.dto;

import java.time.LocalDateTime;

public class ProductDTO {

    private Long id;
    private String name;
    private String sku;
    private String description;
    private Double mrp;
    private Double sellingPrice;
    private String brand;
    private Long categoryId;
    private String category;
    private Long storeId;
    private String image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // No-argument constructor
    public ProductDTO() {
    }


    // All-arguments constructor
    public ProductDTO(Long id,
                      String name,
                      String sku,
                      String description,
                      Double mrp,
                      Double sellingPrice,
                      String brand,
                      Long categoryId,
                      String category,
                      Long storeId,
                      String image,
                      LocalDateTime createdAt,
                      LocalDateTime updatedAt) {

        this.id = id;
        this.name = name;
        this.sku = sku;
        this.description = description;
        this.mrp = mrp;
        this.sellingPrice = sellingPrice;
        this.brand = brand;
        this.categoryId = categoryId;
        this.category = category;
        this.storeId = storeId;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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