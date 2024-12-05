package dev.jeff.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_order_item")
public class OrderItemEntity {

    @EmbeddedId
    private OrderItemId id;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "quantity")
    private Integer quantity;
}
