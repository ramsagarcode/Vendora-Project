package com.zosh.mapper;

import com.zosh.modal.*;
import com.zosh.payload.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShiftReportMapper {

    public static ShiftReportDTO toDTO(ShiftReport shiftReport) {
        if (shiftReport == null) return null;

        ShiftReportDTO dto = new ShiftReportDTO();
        dto.setId(shiftReport.getId());
        dto.setShiftStart(shiftReport.getShiftStart());
        dto.setShiftEnd(shiftReport.getShiftEnd());
        dto.setTotalSales(shiftReport.getTotalSales() != null ? shiftReport.getTotalSales() : 0.0);
        dto.setTotalOrders(shiftReport.getTotalOrders());
        dto.setCashier(UserMapper.toDTO(shiftReport.getCashier()));

        dto.setCashierId(shiftReport.getCashier() != null ? shiftReport.getCashier().getId() : null);
        dto.setBranchId(shiftReport.getBranch() != null ? shiftReport.getBranch().getId() : null);

        dto.setRecentOrders(mapOrders(shiftReport.getRecentOrders()));
        dto.setTopSellingProducts(mapProducts(shiftReport.getTopSellingProducts()));

        return dto;
    }

    private static List<OrderDTO> mapOrders(List<Order> orders) {
        if (orders == null) return List.of();
        return orders.stream()
                .map(OrderMapper::toDto)
                .collect(Collectors.toList());
    }

    private static List<ProductDTO> mapProducts(List<Product> products) {
        if (products == null) return List.of();
        return products.stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

  
}
