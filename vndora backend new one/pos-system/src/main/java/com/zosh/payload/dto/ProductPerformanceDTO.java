package com.zosh.payload.dto;

public class ProductPerformanceDTO {

    private String productName;
    private Long quantitySold;
    private double percentage; // 0–100

    // No-argument constructor
    public ProductPerformanceDTO() {
    }

    // All-arguments constructor
    public ProductPerformanceDTO(String productName,
                                 Long quantitySold,
                                 double percentage) {
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.percentage = percentage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(Long quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}