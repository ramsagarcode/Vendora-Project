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
//public class DashboardSummaryDTO {
//    private Long totalStores;
//    private Long activeStores;
//    private Long blockedStores;
//    private Long pendingStores;
//}
package com.zosh.payload.AdminAnalysis;

public class DashboardSummaryDTO {

    private Long totalStores;
    private Long activeStores;
    private Long blockedStores;
    private Long pendingStores;

    // No-argument constructor
    public DashboardSummaryDTO() {
    }

    // All-arguments constructor
    public DashboardSummaryDTO(Long totalStores, Long activeStores,
                               Long blockedStores, Long pendingStores) {
        this.totalStores = totalStores;
        this.activeStores = activeStores;
        this.blockedStores = blockedStores;
        this.pendingStores = pendingStores;
    }

    public Long getTotalStores() {
        return totalStores;
    }

    public void setTotalStores(Long totalStores) {
        this.totalStores = totalStores;
    }

    public Long getActiveStores() {
        return activeStores;
    }

    public void setActiveStores(Long activeStores) {
        this.activeStores = activeStores;
    }

    public Long getBlockedStores() {
        return blockedStores;
    }

    public void setBlockedStores(Long blockedStores) {
        this.blockedStores = blockedStores;
    }

    public Long getPendingStores() {
        return pendingStores;
    }

    public void setPendingStores(Long pendingStores) {
        this.pendingStores = pendingStores;
    }
}