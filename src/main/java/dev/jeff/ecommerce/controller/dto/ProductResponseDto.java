package dev.jeff.ecommerce.controller.dto;

import dev.jeff.ecommerce.entity.ProductEntity;
import dev.jeff.ecommerce.entity.TagEntity;

import java.util.List;

public record ProductResponseDto(Long productId,
                                 String productName,
                                 List<TagResponseDto> tags) {

    public static ProductResponseDto fromEntity(ProductEntity entity) {
        return new ProductResponseDto(
                entity.getProductId(),
                entity.getProductName(),
                getTags(entity.getTags()));
    }

    public static List<TagResponseDto> getTags(List<TagEntity> entity) {
        return entity.stream()
               .map(TagResponseDto::fromEntity)
               .toList();
    }
}
