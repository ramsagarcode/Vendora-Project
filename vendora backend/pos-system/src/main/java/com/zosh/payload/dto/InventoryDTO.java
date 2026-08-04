package com.zosh.payload.dto;

public class InventoryDTO {

    private Long id;
    private Long branchId;
    private Long productId;
    private Integer quantity;

    // No-argument constructor
    public InventoryDTO() {
    }

    // All-arguments constructor
    public InventoryDTO(Long id, Long branchId, Long productId, Integer quantity) {
        this.id = id;
        this.branchId = branchId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}