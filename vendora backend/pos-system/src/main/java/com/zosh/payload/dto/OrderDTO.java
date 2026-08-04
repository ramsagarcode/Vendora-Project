package com.zosh.payload.dto;

import com.zosh.domain.OrderStatus;
import com.zosh.modal.Customer;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Double totalAmount;
    private Long branchId;
    private Long cashierId;
    private Customer customer;
    private List<OrderItemDTO> items;
    private LocalDateTime createdAt;
    
    private OrderStatus status;

    // No-argument constructor
    public OrderDTO() {
    }

    // All-arguments constructor
    public OrderDTO(Long id,
                    Double totalAmount,
                    Long branchId,
                    Long cashierId,
                    Customer customer,
                    List<OrderItemDTO> items,
                    LocalDateTime createdAt,
                    OrderStatus status) {

        this.id = id;
        this.totalAmount = totalAmount;
        this.branchId = branchId;
        this.cashierId = cashierId;
        this.customer = customer;
        this.items = items;
        this.createdAt = createdAt;
      
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }



    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}