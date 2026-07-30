//package com.zosh.modal;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.*;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.List;
//import java.util.UUID;
//
//@Entity
//@Table(name = "branches")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Branch {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String name;
//
//    private String address;
//
//
//    private String phone;
//
//    private String email;
//
//    /**
//     * Example: ["MONDAY", "TUESDAY", "WEDNESDAY"]
//     */
//    @ElementCollection
//    private List<String> workingDays;
//
//    private LocalTime openTime;
//
//    private LocalTime closeTime;
//
//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;
//
//    @ManyToOne
//    @JoinColumn(name = "store_id")
//    private Store store;
//
//    @OneToOne(cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    private User manager;
//
//    @PrePersist
//    protected void onCreate() {
//        createdAt = updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        updatedAt = LocalDateTime.now();
//    }
//}
package com.zosh.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    private String phone;

    private String email;

    /**
     * Example: ["MONDAY", "TUESDAY", "WEDNESDAY"]
     */
    @ElementCollection
    private List<String> workingDays;

    private LocalTime openTime;

    private LocalTime closeTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JsonIgnore
    private User manager;

    // Default Constructor
    public Branch() {
    }

    // Parameterized Constructor
    public Branch(Long id, String name, String address, String phone, String email,
                  List<String> workingDays, LocalTime openTime, LocalTime closeTime,
                  LocalDateTime createdAt, LocalDateTime updatedAt,
                  Store store, User manager) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.workingDays = workingDays;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.store = store;
        this.manager = manager;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(List<String> workingDays) {
        this.workingDays = workingDays;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Manual Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private String address;
        private String phone;
        private String email;
        private List<String> workingDays;
        private LocalTime openTime;
        private LocalTime closeTime;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Store store;
        private User manager;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder workingDays(List<String> workingDays) {
            this.workingDays = workingDays;
            return this;
        }

        public Builder openTime(LocalTime openTime) {
            this.openTime = openTime;
            return this;
        }

        public Builder closeTime(LocalTime closeTime) {
            this.closeTime = closeTime;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder store(Store store) {
            this.store = store;
            return this;
        }

        public Builder manager(User manager) {
            this.manager = manager;
            return this;
        }

        public Branch build() {
            return new Branch(
                    id,
                    name,
                    address,
                    phone,
                    email,
                    workingDays,
                    openTime,
                    closeTime,
                    createdAt,
                    updatedAt,
                    store,
                    manager
            );
        }
    }
}