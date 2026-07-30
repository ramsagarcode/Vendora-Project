package com.zosh.payload.dto;

public class CategorySalesDTO {

    private String categoryName;
    private Double totalSales;
    private Long quantitySold;

    // No-argument constructor
    public CategorySalesDTO() {
    }

    // All-arguments constructor
    public CategorySalesDTO(String categoryName,
                            Double totalSales,
                            Long quantitySold) {
        this.categoryName = categoryName;
        this.totalSales = totalSales;
        this.quantitySold = quantitySold;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }

    public Long getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(Long quantitySold) {
        this.quantitySold = quantitySold;
    }
}