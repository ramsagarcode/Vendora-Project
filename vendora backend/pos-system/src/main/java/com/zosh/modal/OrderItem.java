//package com.zosh.modal;
//
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "order_items")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class OrderItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Integer quantity;
//
//    private Double price;
//
//    @ManyToOne
//    private Product product;
//
//    @ManyToOne
//    private Order order;
//}
package com.zosh.modal;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private Double price;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;

    // No-argument constructor
    public OrderItem() {
    }

    // All-arguments constructor
    public OrderItem(Long id, Integer quantity, Double price, Product product, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.order = order;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}