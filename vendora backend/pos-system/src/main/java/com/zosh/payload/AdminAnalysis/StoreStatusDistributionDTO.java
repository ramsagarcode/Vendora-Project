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
//public class StoreStatusDistributionDTO {
//    private Long active;
//    private Long blocked;
//    private Long pending;
//}
package com.zosh.payload.AdminAnalysis;

public class StoreStatusDistributionDTO {

    private Long active;
    private Long blocked;
    private Long pending;

    // No-argument constructor
    public StoreStatusDistributionDTO() {
    }

    // All-arguments constructor
    public StoreStatusDistributionDTO(Long active, Long blocked, Long pending) {
        this.active = active;
        this.blocked = blocked;
        this.pending = pending;
    }

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    public Long getBlocked() {
        return blocked;
    }

    public void setBlocked(Long blocked) {
        this.blocked = blocked;
    }

    public Long getPending() {
        return pending;
    }

    public void setPending(Long pending) {
        this.pending = pending;
    }
}