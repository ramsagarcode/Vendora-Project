package com.zosh.payload.StoreAnalysis;

import com.zosh.payload.dto.BranchDTO;
import com.zosh.payload.dto.ProductDTO;

import com.zosh.payload.dto.UserDTO;

import java.util.List;

public class StoreAlertDTO {

    private List<ProductDTO> lowStockAlerts;
    private List<BranchDTO> noSalesToday;
    private List<UserDTO> inactiveCashiers;


    // No-argument constructor
    public StoreAlertDTO() {
    }


    // All-arguments constructor
    public StoreAlertDTO(List<ProductDTO> lowStockAlerts,
                         List<BranchDTO> noSalesToday,
                         List<UserDTO> inactiveCashiers) {

        this.lowStockAlerts = lowStockAlerts;
        this.noSalesToday = noSalesToday;
        this.inactiveCashiers = inactiveCashiers;
    }


    public List<ProductDTO> getLowStockAlerts() {
        return lowStockAlerts;
    }

    public void setLowStockAlerts(List<ProductDTO> lowStockAlerts) {
        this.lowStockAlerts = lowStockAlerts;
    }


    public List<BranchDTO> getNoSalesToday() {
        return noSalesToday;
    }

    public void setNoSalesToday(List<BranchDTO> noSalesToday) {
        this.noSalesToday = noSalesToday;
    }


   

   


    public List<UserDTO> getInactiveCashiers() {
        return inactiveCashiers;
    }

    public void setInactiveCashiers(List<UserDTO> inactiveCashiers) {
        this.inactiveCashiers = inactiveCashiers;
    }
}