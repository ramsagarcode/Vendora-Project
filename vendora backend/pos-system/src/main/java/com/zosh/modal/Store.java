//package com.zosh.modal;
//
//
//import com.zosh.domain.StoreStatus;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import lombok.*;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.UUID;
//
//@Entity
//@Table(name = "stores")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Store {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(nullable = false)
//    @NotBlank(message = "brand name is required")
//    private String brand;
//
//    @OneToOne
//    private User storeAdmin;
//
//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;
//
//    private String description;
//
//    private String storeType;
//
//    private StoreStatus status;
//
//    // Contact Information
//    @Embedded
//    private StoreContact contact=new StoreContact();
//
//    @PrePersist
//    protected void onCreate() {
//        createdAt = updatedAt = LocalDateTime.now();
//        status=StoreStatus.PENDING;
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        updatedAt = LocalDateTime.now();
//    }
//}
package com.zosh.modal;

import com.zosh.domain.StoreStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "brand name is required")
    private String brand;

    @OneToOne
    private User storeAdmin;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String description;

    private String storeType;

    private StoreStatus status;

    // Contact Information
    @Embedded
    private StoreContact contact = new StoreContact();

    // No-argument constructor
    public Store() {
    }

    // All-arguments constructor
    public Store(Long id, String brand, User storeAdmin,
                 LocalDateTime createdAt, LocalDateTime updatedAt,
                 String description, String storeType,
                 StoreStatus status, StoreContact contact) {
        this.id = id;
        this.brand = brand;
        this.storeAdmin = storeAdmin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.storeType = storeType;
        this.status = status;
        this.contact = contact;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        status = StoreStatus.PENDING;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
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

    public User getStoreAdmin() {
        return storeAdmin;
    }

    public void setStoreAdmin(User storeAdmin) {
        this.storeAdmin = storeAdmin;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public StoreContact getContact() {
        return contact;
    }

    public void setContact(StoreContact contact) {
        this.contact = contact;
    }
}
