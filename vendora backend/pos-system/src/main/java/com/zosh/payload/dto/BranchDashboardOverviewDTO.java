package com.zosh.payload.dto;

import java.math.BigDecimal;

public class BranchDashboardOverviewDTO {

    private BigDecimal totalSales;
    private double salesGrowth;

    private int ordersToday;
    private double orderGrowth;

    private int activeCashiers;
    private double cashierGrowth;

    private int lowStockItems;
    private double lowStockGrowth;


    // No-argument constructor
    public BranchDashboardOverviewDTO() {
    }

    // All-arguments constructor
    public BranchDashboardOverviewDTO(BigDecimal totalSales,
                                      double salesGrowth,
                                      int ordersToday,
                                      double orderGrowth,
                                      int activeCashiers,
                                      double cashierGrowth,
                                      int lowStockItems,
                                      double lowStockGrowth) {
        this.totalSales = totalSales;
        this.salesGrowth = salesGrowth;
        this.ordersToday = ordersToday;
        this.orderGrowth = orderGrowth;
        this.activeCashiers = activeCashiers;
        this.cashierGrowth = cashierGrowth;
        this.lowStockItems = lowStockItems;
        this.lowStockGrowth = lowStockGrowth;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public double getSalesGrowth() {
        return salesGrowth;
    }

    public void setSalesGrowth(double salesGrowth) {
        this.salesGrowth = salesGrowth;
    }

    public int getOrdersToday() {
        return ordersToday;
    }

    public void setOrdersToday(int ordersToday) {
        this.ordersToday = ordersToday;
    }

    public double getOrderGrowth() {
        return orderGrowth;
    }

    public void setOrderGrowth(double orderGrowth) {
        this.orderGrowth = orderGrowth;
    }

    public int getActiveCashiers() {
        return activeCashiers;
    }

    public void setActiveCashiers(int activeCashiers) {
        this.activeCashiers = activeCashiers;
    }

    public double getCashierGrowth() {
        return cashierGrowth;
    }

    public void setCashierGrowth(double cashierGrowth) {
        this.cashierGrowth = cashierGrowth;
    }

    public int getLowStockItems() {
        return lowStockItems;
    }

    public void setLowStockItems(int lowStockItems) {
        this.lowStockItems = lowStockItems;
    }

    public double getLowStockGrowth() {
        return lowStockGrowth;
    }

    public void setLowStockGrowth(double lowStockGrowth) {
        this.lowStockGrowth = lowStockGrowth;
    }
}