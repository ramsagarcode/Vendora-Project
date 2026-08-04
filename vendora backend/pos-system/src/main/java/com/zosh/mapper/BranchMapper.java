//package com.zosh.mapper;
//
//
//import com.zosh.modal.Branch;
//import com.zosh.modal.Store;
//import com.zosh.payload.dto.BranchDTO;
//
//public class BranchMapper {
//
//    public static BranchDTO toDto(Branch branch) {
//        return BranchDTO.builder()
//                .id(branch.getId())
//                .name(branch.getName())
//                .address(branch.getAddress())
//                .phone(branch.getPhone())
//                .email(branch.getEmail())
//                .closeTime(branch.getCloseTime())
//                .openTime(branch.getOpenTime())
//                .workingDays(branch.getWorkingDays())
//                .storeId(branch.getStore() != null ? branch.getStore().getId() : null)
//                .store(StoreMapper.toDto(branch.getStore()))
//                .createdAt(branch.getCreatedAt())
//                .updatedAt(branch.getUpdatedAt())
//                .manager(branch.getManager()!=null?
//                        branch.getManager().getFullName():null)
//                .build();
//    }
//
//    public static Branch toEntity(BranchDTO dto, Store store) {
//        return Branch.builder()
//                .id(dto.getId())
//                .name(dto.getName())
//                .address(dto.getAddress())
//                .store(store)
//                .email(dto.getEmail())
//                .phone(dto.getPhone())
//                .closeTime(dto.getCloseTime())
//                .openTime(dto.getOpenTime())
//                .workingDays(dto.getWorkingDays())
//                .createdAt(dto.getCreatedAt())
//                .updatedAt(dto.getUpdatedAt())
//
//                .build();
//    }
//}
package com.zosh.mapper;

import com.zosh.modal.Branch;
import com.zosh.modal.Store;
import com.zosh.payload.dto.BranchDTO;

public class BranchMapper {

    public static BranchDTO toDto(Branch branch) {

        BranchDTO dto = new BranchDTO();

        dto.setId(branch.getId());
        dto.setName(branch.getName());
        dto.setAddress(branch.getAddress());
        dto.setPhone(branch.getPhone());
        dto.setEmail(branch.getEmail());
        dto.setCloseTime(branch.getCloseTime());
        dto.setOpenTime(branch.getOpenTime());
        dto.setWorkingDays(branch.getWorkingDays());

        dto.setStoreId(branch.getStore() != null ? branch.getStore().getId() : null);
        dto.setStore(StoreMapper.toDto(branch.getStore()));

        dto.setCreatedAt(branch.getCreatedAt());
        dto.setUpdatedAt(branch.getUpdatedAt());

        dto.setManager(
                branch.getManager() != null
                        ? branch.getManager().getFullName()
                        : null
        );

        return dto;
    }

    public static Branch toEntity(BranchDTO dto, Store store) {

        Branch branch = new Branch();

        branch.setId(dto.getId());
        branch.setName(dto.getName());
        branch.setAddress(dto.getAddress());
        branch.setStore(store);
        branch.setEmail(dto.getEmail());
        branch.setPhone(dto.getPhone());
        branch.setCloseTime(dto.getCloseTime());
        branch.setOpenTime(dto.getOpenTime());
        branch.setWorkingDays(dto.getWorkingDays());
        branch.setCreatedAt(dto.getCreatedAt());
        branch.setUpdatedAt(dto.getUpdatedAt());

        return branch;
    }
}
