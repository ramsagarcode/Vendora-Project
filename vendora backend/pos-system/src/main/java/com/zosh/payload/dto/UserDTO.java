package com.zosh.payload.dto;

import com.zosh.domain.UserRole;

import java.time.LocalDateTime;

public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String phone;
    private String fullName;
    private UserRole role;
    private String username;
    private Long storeId;
    private Long branchId;
    private BranchDTO branch;
    private String branchName;
    private LocalDateTime lastLogin;


    // No-argument constructor
    public UserDTO() {
    }


    // Parameterized constructor
    public UserDTO(Long id,
                   String email,
                   String fullName,
                   UserRole role,
                   String branchName,
                   LocalDateTime lastLogin) {

        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.password = null;
        this.phone = null;
        this.username = null;
        this.storeId = null;
        this.branchId = null;
        this.branch = null;
        this.branchName = branchName;
        this.lastLogin = lastLogin;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public BranchDTO getBranch() {
        return branch;
    }

    public void setBranch(BranchDTO branch) {
        this.branch = branch;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}