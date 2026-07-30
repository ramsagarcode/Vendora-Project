package com.zosh.payload.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ShiftReportDTO {

    private Long id;
    private LocalDateTime shiftStart;
    private LocalDateTime shiftEnd;
    private double totalSales;
    private int totalOrders;
    private UserDTO cashier;
    private Long cashierId;
    private Long branchId;
    private List<OrderDTO> recentOrders;
    private List<ProductDTO> topSellingProducts;

    // No-argument constructor
    public ShiftReportDTO() {
    }

    // All-arguments constructor
    public ShiftReportDTO(Long id,
                          LocalDateTime shiftStart,
                          LocalDateTime shiftEnd,
                          double totalSales,
                          int totalOrders,
                          UserDTO cashier,
                          Long cashierId,
                          Long branchId,
                          List<OrderDTO> recentOrders,
                          List<ProductDTO> topSellingProducts) {

        this.id = id;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.totalSales = totalSales;
        this.totalOrders = totalOrders;
        this.cashier = cashier;
        this.cashierId = cashierId;
        this.branchId = branchId;
        this.recentOrders = recentOrders;
        this.topSellingProducts = topSellingProducts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(LocalDateTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public LocalDateTime getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(LocalDateTime shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public UserDTO getCashier() {
        return cashier;
    }

    public void setCashier(UserDTO cashier) {
        this.cashier = cashier;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public List<OrderDTO> getRecentOrders() {
        return recentOrders;
    }

    public void setRecentOrders(List<OrderDTO> recentOrders) {
        this.recentOrders = recentOrders;
    }

    public List<ProductDTO> getTopSellingProducts() {
        return topSellingProducts;
    }

    public void setTopSellingProducts(List<ProductDTO> topSellingProducts) {
        this.topSellingProducts = topSellingProducts;
    }
}