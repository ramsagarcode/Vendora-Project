package com.zosh.payload.StoreAnalysis;

import java.util.List;

public class BranchPerformanceDTO {

    private List<BranchSalesDTO> branchSales;
    private Integer newBranchesThisMonth;
    private String topBranch;


    // No-argument constructor
    public BranchPerformanceDTO() {
    }


    // All-arguments constructor
    public BranchPerformanceDTO(List<BranchSalesDTO> branchSales,
                                Integer newBranchesThisMonth,
                                String topBranch) {
        this.branchSales = branchSales;
        this.newBranchesThisMonth = newBranchesThisMonth;
        this.topBranch = topBranch;
    }


    public List<BranchSalesDTO> getBranchSales() {
        return branchSales;
    }

    public void setBranchSales(List<BranchSalesDTO> branchSales) {
        this.branchSales = branchSales;
    }


    public Integer getNewBranchesThisMonth() {
        return newBranchesThisMonth;
    }

    public void setNewBranchesThisMonth(Integer newBranchesThisMonth) {
        this.newBranchesThisMonth = newBranchesThisMonth;
    }


    public String getTopBranch() {
        return topBranch;
    }

    public void setTopBranch(String topBranch) {
        this.topBranch = topBranch;
    }
}