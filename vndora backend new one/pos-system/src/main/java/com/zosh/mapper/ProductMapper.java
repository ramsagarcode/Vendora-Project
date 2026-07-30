//package com.zosh.mapper;
//
//import com.zosh.modal.Category;
//import com.zosh.modal.Product;
//import com.zosh.modal.Store;
//import com.zosh.payload.dto.ProductDTO;
//
//public class ProductMapper {
//
//    public static ProductDTO toDto(Product product) {
//        return ProductDTO.builder()
//                .id(product.getId())
//                .name(product.getName())
//                .sku(product.getSku())
//                .description(product.getDescription())
//                .mrp(product.getMrp())
//                .sellingPrice(product.getSellingPrice())
//                .brand(product.getBrand())
//                .category(product.getCategory().getName())
//                .categoryId(product.getCategory().getId())
//                .storeId(product.getStore() != null ? product.getStore().getId() : null)
//                .image(product.getImage())
//                .createdAt(product.getCreatedAt())
//                .updatedAt(product.getUpdatedAt())
//                .build();
//    }
//
//    public static Product toEntity(ProductDTO dto,
//                                   Store store,
//                                   Category category) {
//        return Product.builder()
//                .id(dto.getId())
//                .name(dto.getName())
//                .sku(dto.getSku())
//                .description(dto.getDescription())
//                .mrp(dto.getMrp())
//                .sellingPrice(dto.getSellingPrice())
//                .brand(dto.getBrand())
//                .category(category)
//
//                .store(store)
//                .image(dto.getImage())
//                .createdAt(dto.getCreatedAt())
//                .updatedAt(dto.getUpdatedAt())
//                .build();
//    }
//}
package com.zosh.mapper;

import com.zosh.modal.Category;
import com.zosh.modal.Product;
import com.zosh.modal.Store;
import com.zosh.payload.dto.ProductDTO;

public class ProductMapper {

    public static ProductDTO toDto(Product product) {

        ProductDTO dto = new ProductDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setSku(product.getSku());
        dto.setDescription(product.getDescription());
        dto.setMrp(product.getMrp());
        dto.setSellingPrice(product.getSellingPrice());
        dto.setBrand(product.getBrand());
        dto.setCategory(product.getCategory().getName());
        dto.setCategoryId(product.getCategory().getId());
        dto.setStoreId(product.getStore() != null ? product.getStore().getId() : null);
        dto.setImage(product.getImage());
        dto.setCreatedAt(product.getCreatedAt());
        dto.setUpdatedAt(product.getUpdatedAt());

        return dto;
    }

    public static Product toEntity(ProductDTO dto,
                                   Store store,
                                   Category category) {

        Product product = new Product();

        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setSku(dto.getSku());
        product.setDescription(dto.getDescription());
        product.setMrp(dto.getMrp());
        product.setSellingPrice(dto.getSellingPrice());
        product.setBrand(dto.getBrand());
        product.setCategory(category);
        product.setStore(store);
        product.setImage(dto.getImage());
        product.setCreatedAt(dto.getCreatedAt());
        product.setUpdatedAt(dto.getUpdatedAt());

        return product;
    }
}
