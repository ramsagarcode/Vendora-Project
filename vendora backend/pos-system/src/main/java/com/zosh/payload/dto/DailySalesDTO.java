package com.zosh.payload.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DailySalesDTO {

    private LocalDate date;
    private BigDecimal totalSales;

    // No-argument constructor
    public DailySalesDTO() {
    }

    // All-arguments constructor
    public DailySalesDTO(LocalDate date, BigDecimal totalSales) {
        this.date = date;
        this.totalSales = totalSales;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }
}