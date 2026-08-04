package com.zosh.payload.StoreAnalysis;

public class BranchSalesDTO {

    private String branchName;
    private Double totalSales;


    // No-argument constructor
    public BranchSalesDTO() {
    }


    // All-arguments constructor
    public BranchSalesDTO(String branchName, Double totalSales) {
        this.branchName = branchName;
        this.totalSales = totalSales;
    }


    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }


    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }
}