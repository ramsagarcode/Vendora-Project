//package com.zosh.mapper;
//
//import com.zosh.modal.Store;
//import com.zosh.modal.User;
//import com.zosh.payload.dto.StoreDTO;
//
//public class StoreMapper {
//
//
//
//
//
//        public static StoreDTO toDto(Store store) {
//            return StoreDTO.builder()
//                    .id(store.getId())
//                    .brand(store.getBrand())
//                    .storeAdminId(store.getStoreAdmin() != null ? store.getStoreAdmin().getId() : null)
//                    .storeAdmin(UserMapper.toDTO(store.getStoreAdmin()))
//                    .storeType(store.getStoreType())
//                    .description(store.getDescription())
//                    .contact(store.getContact())
//                    .createdAt(store.getCreatedAt())
//                    .updatedAt(store.getUpdatedAt())
//                    .status(store.getStatus())
//                    .build();
//        }
//
//        public static Store toEntity(StoreDTO dto, User storeAdmin) {
//            return Store.builder()
//                    .id(dto.getId())
//                    .brand(dto.getBrand())
//                    .storeAdmin(storeAdmin)
//                    .createdAt(dto.getCreatedAt())
//                    .updatedAt(dto.getUpdatedAt())
//                    .storeType(dto.getStoreType())
//                    .description(dto.getDescription())
//                    .build();
//        }
//    }
//
//
package com.zosh.mapper;

import com.zosh.modal.Store;
import com.zosh.modal.User;
import com.zosh.payload.dto.StoreDTO;

public class StoreMapper {

    public static StoreDTO toDto(Store store) {

        StoreDTO dto = new StoreDTO();

        dto.setId(store.getId());
        dto.setBrand(store.getBrand());
        dto.setStoreAdminId(store.getStoreAdmin() != null ? store.getStoreAdmin().getId() : null);
        dto.setStoreAdmin(UserMapper.toDTO(store.getStoreAdmin()));
        dto.setStoreType(store.getStoreType());
        dto.setDescription(store.getDescription());
        dto.setContact(store.getContact());
        dto.setCreatedAt(store.getCreatedAt());
        dto.setUpdatedAt(store.getUpdatedAt());
        dto.setStatus(store.getStatus());

        return dto;
    }

    public static Store toEntity(StoreDTO dto, User storeAdmin) {

        Store store = new Store();

        store.setId(dto.getId());
        store.setBrand(dto.getBrand());
        store.setStoreAdmin(storeAdmin);
        store.setCreatedAt(dto.getCreatedAt());
        store.setUpdatedAt(dto.getUpdatedAt());
        store.setStoreType(dto.getStoreType());
        store.setDescription(dto.getDescription());

        return store;
    }
}