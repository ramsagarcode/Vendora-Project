package com.zosh.controller;

import com.zosh.payload.AdminAnalysis.DashboardSummaryDTO;
import com.zosh.payload.AdminAnalysis.StoreRegistrationStatDTO;
import com.zosh.payload.AdminAnalysis.StoreStatusDistributionDTO;
import com.zosh.service.AdminDashboardService;
import com.zosh.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/super-admin")
public class AdminDashboardController {

    private final AdminDashboardService adminDashboardService;
    private final StoreService storeService;

    public AdminDashboardController(AdminDashboardService adminDashboardService,
                                    StoreService storeService) {
        this.adminDashboardService = adminDashboardService;
        this.storeService = storeService;
    }

    @GetMapping("/dashboard/summary")
    public DashboardSummaryDTO getDashboardSummary() {
        return adminDashboardService.getDashboardSummary();
    }

    @GetMapping("/dashboard/store-registrations")
    public List<StoreRegistrationStatDTO> getLast7DayRegistrationStats() {
        return adminDashboardService.getLast7DayRegistrationStats();
    }

    @GetMapping("/dashboard/store-status-distribution")
    public StoreStatusDistributionDTO getStoreStatusDistribution() {
        return adminDashboardService.getStoreStatusDistribution();
    }
}