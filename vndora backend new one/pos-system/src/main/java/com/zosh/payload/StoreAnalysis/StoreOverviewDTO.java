package com.zosh.payload.StoreAnalysis;

public class StoreOverviewDTO {

    private Integer totalBranches;
    private Double totalSales;
    private Integer totalOrders;
    private Integer totalEmployees;
    private Integer totalCustomers;
    private Integer totalRefunds;
    private Integer totalProducts;
    private String topBranchName;


    // No-argument constructor
    public StoreOverviewDTO() {
    }


    // All-arguments constructor
    public StoreOverviewDTO(Integer totalBranches,
                            Double totalSales,
                            Integer totalOrders,
                            Integer totalEmployees,
                            Integer totalCustomers,
                            Integer totalRefunds,
                            Integer totalProducts,
                            String topBranchName) {

        this.totalBranches = totalBranches;
        this.totalSales = totalSales;
        this.totalOrders = totalOrders;
        this.totalEmployees = totalEmployees;
        this.totalCustomers = totalCustomers;
        this.totalRefunds = totalRefunds;
        this.totalProducts = totalProducts;
        this.topBranchName = topBranchName;
    }


    public Integer getTotalBranches() {
        return totalBranches;
    }

    public void setTotalBranches(Integer totalBranches) {
        this.totalBranches = totalBranches;
    }


    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }


    public Integer getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }


    public Integer getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(Integer totalEmployees) {
        this.totalEmployees = totalEmployees;
    }


    public Integer getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(Integer totalCustomers) {
        this.totalCustomers = totalCustomers;
    }


    public Integer getTotalRefunds() {
        return totalRefunds;
    }

    public void setTotalRefunds(Integer totalRefunds) {
        this.totalRefunds = totalRefunds;
    }


    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }


    public String getTopBranchName() {
        return topBranchName;
    }

    public void setTopBranchName(String topBranchName) {
        this.topBranchName = topBranchName;
    }
}