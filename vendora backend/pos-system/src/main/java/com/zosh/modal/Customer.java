//package com.zosh.modal;
//
//import com.zosh.domain.UserRole;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Customer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank(message = "fullName is mandatory")
//    private String fullName;
//
//    private String email;
//
//    private String phone;
//
//
//    @Column(nullable = false, updatable = false)
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    @Column(nullable = false)
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;
//
//}
package com.zosh.modal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "fullName is mandatory")
    private String fullName;

    private String email;

    private String phone;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // No-argument constructor
    public Customer() {
    }

    // All-arguments constructor
    public Customer(Long id, String fullName, String email, String phone,
                    LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
