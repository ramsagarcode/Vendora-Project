package com.zosh.payload.dto;

import com.zosh.domain.StoreStatus;
import com.zosh.modal.StoreContact;

import java.time.LocalDateTime;

public class StoreDTO {

    private Long id;
    private String brand;
    private Long storeAdminId;
    private UserDTO storeAdmin;
    private String storeType;
    private StoreStatus status;
    private String description;
    private StoreContact contact;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // No-argument constructor
    public StoreDTO() {
    }


    // All-arguments constructor
    public StoreDTO(Long id,
                    String brand,
                    Long storeAdminId,
                    UserDTO storeAdmin,
                    String storeType,
                    StoreStatus status,
                    String description,
                    StoreContact contact,
                    LocalDateTime createdAt,
                    LocalDateTime updatedAt) {

        this.id = id;
        this.brand = brand;
        this.storeAdminId = storeAdminId;
        this.storeAdmin = storeAdmin;
        this.storeType = storeType;
        this.status = status;
        this.description = description;
        this.contact = contact;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getStoreAdminId() {
        return storeAdminId;
    }

    public void setStoreAdminId(Long storeAdminId) {
        this.storeAdminId = storeAdminId;
    }

    public UserDTO getStoreAdmin() {
        return storeAdmin;
    }

    public void setStoreAdmin(UserDTO storeAdmin) {
        this.storeAdmin = storeAdmin;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public StoreStatus getStatus() {
        return status;
    }

    public void setStatus(StoreStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StoreContact getContact() {
        return contact;
    }

    public void setContact(StoreContact contact) {
        this.contact = contact;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}