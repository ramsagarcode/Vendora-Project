package com.zosh.payload.StoreAnalysis;

import java.util.List;

public class TimeSeriesDataDTO {

    private List<TimeSeriesPointDTO> points;
    private String period; // DAILY, WEEKLY, MONTHLY


    // No-argument constructor
    public TimeSeriesDataDTO() {
    }


    // All-arguments constructor
    public TimeSeriesDataDTO(List<TimeSeriesPointDTO> points,
                             String period) {
        this.points = points;
        this.period = period;
    }


    public List<TimeSeriesPointDTO> getPoints() {
        return points;
    }

    public void setPoints(List<TimeSeriesPointDTO> points) {
        this.points = points;
    }


    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}