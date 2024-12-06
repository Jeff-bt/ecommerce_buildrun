package dev.jeff.ecommerce.service;

import dev.jeff.ecommerce.controller.dto.CreateOrderDto;
import dev.jeff.ecommerce.controller.dto.OrderItemDto;
import dev.jeff.ecommerce.controller.dto.OrderSummaryDto;
import dev.jeff.ecommerce.entity.*;
import dev.jeff.ecommerce.exception.CreateOrderException;
import dev.jeff.ecommerce.repository.OrderRepository;
import dev.jeff.ecommerce.repository.ProductRepository;
import dev.jeff.ecommerce.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(UserRepository userRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderEntity createOrder(CreateOrderDto body){
        OrderEntity order = new OrderEntity();

        UserEntity user = validateUser(body);
        List<OrderItemEntity> orderItems = validateOrderItems(order, body);

        BigDecimal total = calculateOrderTotal(orderItems);

        order.setUser(user);
        order.setItems(orderItems);
        order.setTotal(total);
        order.setOrderDate(LocalDateTime.now());

        return orderRepository.save(order);
    }

    private UserEntity validateUser(CreateOrderDto body) {
        return userRepository.findById(body.userId()).orElseThrow(() -> new CreateOrderException("user not found"));
    }

    private List<OrderItemEntity> validateOrderItems(OrderEntity order, CreateOrderDto body) {
        if (body.items().isEmpty()) {
            throw new CreateOrderException("order items is empty");
        }

        return body.items().stream()
                .map(orderItemDto -> getOrderItem(order, orderItemDto))
                .toList();
    }

    private OrderItemEntity getOrderItem(OrderEntity order, OrderItemDto orderItemDto) {
        var orderItemEntity = new OrderItemEntity();
        var product = getProduct(orderItemDto.productId());

        var id = new OrderItemId();
        id.setProduct(product);
        id.setOrder(order);

        orderItemEntity.setId(id);
        orderItemEntity.setQuantity(orderItemDto.quantity());
        orderItemEntity.setSalePrice(product.getPrice());

        return orderItemEntity;
    }

    private ProductEntity getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new CreateOrderException("product not found"));
    }

    private BigDecimal calculateOrderTotal(List<OrderItemEntity> items) {
        return items.stream()
                .map(item -> item.getSalePrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public Page<OrderSummaryDto> findAll(Integer page, Integer pageSize, String orderBy) {
        PageRequest pageRequest = getPageRequest(page, pageSize, orderBy);
        Page<OrderEntity> orders = orderRepository.findAll(pageRequest);

        return orders.map(order -> OrderSummaryDto.fromEntity(order));
    }

    private PageRequest getPageRequest(Integer page, Integer pageSize, String orderBy) {
        Direction direction = Direction.DESC;
        if (orderBy.equalsIgnoreCase("asc")) {
            direction = Direction.ASC;
        }

        return PageRequest.of(page, pageSize, direction, "orderDate");
    }

    public Optional<OrderEntity> findbyId(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
