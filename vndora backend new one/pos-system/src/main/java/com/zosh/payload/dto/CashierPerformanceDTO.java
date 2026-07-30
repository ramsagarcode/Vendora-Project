package com.zosh.payload.dto;

public class CashierPerformanceDTO {

    private Long cashierId;
    private String cashierName;
    private Long totalOrders;
    private Double totalRevenue;

    // No-argument constructor
    public CashierPerformanceDTO() {
    }

    // All-arguments constructor
    public CashierPerformanceDTO(Long cashierId,
                                 String cashierName,
                                 Long totalOrders,
                                 Double totalRevenue) {
        this.cashierId = cashierId;
        this.cashierName = cashierName;
        this.totalOrders = totalOrders;
        this.totalRevenue = totalRevenue;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public Long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}