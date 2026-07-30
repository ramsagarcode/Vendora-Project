package com.zosh.payload.StoreAnalysis;

import java.time.LocalDateTime;

public class TimeSeriesPointDTO {

    private LocalDateTime date;
    private Double totalAmount;


    // No-argument constructor
    public TimeSeriesPointDTO() {
    }


    // All-arguments constructor
    public TimeSeriesPointDTO(LocalDateTime date,
                              Double totalAmount) {
        this.date = date;
        this.totalAmount = totalAmount;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}