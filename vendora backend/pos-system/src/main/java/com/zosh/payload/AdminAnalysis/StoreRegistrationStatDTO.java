//package com.zosh.payload.AdminAnalysis;
//
//
//import lombok.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class StoreRegistrationStatDTO {
//    private String date; // formatted as yyyy-MM-dd
//    private Long count;
//}
package com.zosh.payload.AdminAnalysis;

public class StoreRegistrationStatDTO {

    private String date; // formatted as yyyy-MM-dd
    private Long count;

    // No-argument constructor
    public StoreRegistrationStatDTO() {
    }

    // All-arguments constructor
    public StoreRegistrationStatDTO(String date, Long count) {
        this.date = date;
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}