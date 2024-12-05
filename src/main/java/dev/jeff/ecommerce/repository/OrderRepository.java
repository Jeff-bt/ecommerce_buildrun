package dev.jeff.ecommerce.repository;

import dev.jeff.ecommerce.entity.OrderEntity;
import dev.jeff.ecommerce.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
