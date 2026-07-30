
package com.zosh.mapper;

import com.zosh.modal.OrderItem;
import com.zosh.payload.dto.OrderItemDTO;

public class OrderItemMapper {

    public static OrderItemDTO toDto(OrderItem item) {

        if (item == null) {
            return null;
        }

        OrderItemDTO dto = new OrderItemDTO();

        dto.setId(item.getId());
        dto.setProductId(item.getProduct() != null ? item.getProduct().getId() : null);
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getPrice());
        dto.setProduct(item.getProduct() != null ? ProductMapper.toDto(item.getProduct()) : null);

        return dto;
    }
}

