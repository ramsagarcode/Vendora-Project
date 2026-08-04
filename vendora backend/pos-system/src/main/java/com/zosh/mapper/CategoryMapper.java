//package com.zosh.mapper;
//
//import com.zosh.modal.Category;
//import com.zosh.payload.dto.CategoryDTO;
//
//public class CategoryMapper {
//
//    public static CategoryDTO toDto(Category category) {
//        return CategoryDTO.builder()
//                .id(category.getId())
//                .name(category.getName())
//                .storeId(category.getStore().getId())
//                .build();
//    }
//}
package com.zosh.mapper;

import com.zosh.modal.Category;
import com.zosh.payload.dto.CategoryDTO;

public class CategoryMapper {

    public static CategoryDTO toDto(Category category) {

        CategoryDTO dto = new CategoryDTO();

        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setStoreId(category.getStore().getId());

        return dto;
    }
}