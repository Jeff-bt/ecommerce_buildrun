package dev.jeff.ecommerce.repository;

import dev.jeff.ecommerce.entity.OrderEntity;
import dev.jeff.ecommerce.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
