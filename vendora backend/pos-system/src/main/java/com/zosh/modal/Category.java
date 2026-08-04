//package com.zosh.modal;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "categories")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Category {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    @ManyToOne
//    private Store store;
//}
package com.zosh.modal;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Store store;

    // Default Constructor
    public Category() {
    }

    // Parameterized Constructor
    public Category(Long id, String name, Store store) {
        this.id = id;
        this.name = name;
        this.store = store;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    // Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private Store store;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder store(Store store) {
            this.store = store;
            return this;
        }

        public Category build() {
            return new Category(id, name, store);
        }
    }
}