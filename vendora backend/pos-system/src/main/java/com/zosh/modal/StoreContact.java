//package com.zosh.modal;
//
//
//
//import jakarta.persistence.Embeddable;
//import jakarta.validation.constraints.Email;
//import lombok.*;
//
//@Embeddable
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class StoreContact {
//
//    private String address;
//
//    private String phone;
//
//    @Email(message = "Invalid email format")
//    private String email;
//}
package com.zosh.modal;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

@Embeddable
public class StoreContact {

    private String address;

    private String phone;

    @Email(message = "Invalid email format")
    private String email;

    // No-argument constructor
    public StoreContact() {
    }

    // All-arguments constructor
    public StoreContact(String address, String phone, String email) {
        this.address = address;
        this.phone = phone;
        this.email = email;
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
}