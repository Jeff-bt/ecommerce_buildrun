package dev.jeff.ecommerce.controller.dto;

import dev.jeff.ecommerce.entity.OrderEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderSummaryDto(Long orderId,
                              LocalDateTime orderDate,
                              UUID userId,
                              BigDecimal total) {

    public static OrderSummaryDto fromEntity (OrderEntity entity) {
         return new OrderSummaryDto(
                 entity.getId(),
                 entity.getOrderDate(),
                 entity.getUser().getUserId(),
                 entity.getTotal()
         );
    }

}
