//package com.zosh.mapper;
//
//
//import com.zosh.modal.Branch;
//import com.zosh.modal.Inventory;
//import com.zosh.modal.Product;
//import com.zosh.payload.dto.InventoryDTO;
//
//public class InventoryMapper {
//
//    public static InventoryDTO toDto(Inventory inventory) {
//        return InventoryDTO.builder()
//                .id(inventory.getId())
//                .branchId(inventory.getBranch().getId())
//                .productId(inventory.getProduct().getId())
//                .quantity(inventory.getQuantity())
//                .build();
//    }
//
//    public static Inventory toEntity(InventoryDTO dto, Branch branch, Product product) {
//        return Inventory.builder()
//                .id(dto.getId())
//                .branch(branch)
//                .product(product)
//                .quantity(dto.getQuantity())
//                .build();
//    }
//}
//
package com.zosh.mapper;

import com.zosh.modal.Branch;
import com.zosh.modal.Inventory;
import com.zosh.modal.Product;
import com.zosh.payload.dto.InventoryDTO;

public class InventoryMapper {

    public static InventoryDTO toDto(Inventory inventory) {

        InventoryDTO dto = new InventoryDTO();

        dto.setId(inventory.getId());
        dto.setBranchId(inventory.getBranch().getId());
        dto.setProductId(inventory.getProduct().getId());
        dto.setQuantity(inventory.getQuantity());

        return dto;
    }

    public static Inventory toEntity(InventoryDTO dto, Branch branch, Product product) {

        Inventory inventory = new Inventory();

        inventory.setId(dto.getId());
        inventory.setBranch(branch);
        inventory.setProduct(product);
        inventory.setQuantity(dto.getQuantity());

        return inventory;
    }
}