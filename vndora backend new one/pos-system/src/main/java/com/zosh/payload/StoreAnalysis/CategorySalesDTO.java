package com.zosh.payload.StoreAnalysis;

public class CategorySalesDTO {

    private String categoryName;
    private Double totalSales;


    // No-argument constructor
    public CategorySalesDTO() {
    }


    // All-arguments constructor
    public CategorySalesDTO(String categoryName, Double totalSales) {
        this.categoryName = categoryName;
        this.totalSales = totalSales;
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
}