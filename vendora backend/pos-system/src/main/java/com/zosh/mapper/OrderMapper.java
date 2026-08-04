//package com.zosh.mapper;
//
//
//import com.zosh.modal.Order;
//import com.zosh.modal.OrderItem;
//import com.zosh.payload.dto.OrderDTO;
//import com.zosh.payload.dto.OrderItemDTO;
//
//import java.util.stream.Collectors;
//
//public class OrderMapper {
//
//    public static OrderDTO toDto(Order order) {
//        return OrderDTO.builder()
//                .id(order.getId())
//                .totalAmount(order.getTotalAmount())
//                .branchId(order.getBranch().getId())
//                .cashierId(order.getCashier().getId())
//                .customer(order.getCustomer())
//                .createdAt(order.getCreatedAt())
//                .paymentType(order.getPaymentType())
//                .status(order.getStatus())
//                .items(order.getItems().stream()
//                        .map(OrderItemMapper::toDto)
//                        .collect(Collectors.toList()))
//                .build();
//    }
//}
//
package com.zosh.mapper;

import com.zosh.modal.Order;
import com.zosh.payload.dto.OrderDTO;

import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDTO toDto(Order order) {

        OrderDTO dto = new OrderDTO();

        dto.setId(order.getId());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setBranchId(order.getBranch().getId());
        dto.setCashierId(order.getCashier().getId());
        dto.setCustomer(order.getCustomer());
        dto.setCreatedAt(order.getCreatedAt());
        
        dto.setStatus(order.getStatus());

        dto.setItems(order.getItems()
                .stream()
                .map(OrderItemMapper::toDto)
                .collect(Collectors.toList()));

        return dto;
    }
}