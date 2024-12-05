package dev.jeff.ecommerce.controller;

import dev.jeff.ecommerce.controller.dto.CreateOrderDto;
import dev.jeff.ecommerce.entity.OrderEntity;
import dev.jeff.ecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderDto body) {
        OrderEntity order = orderService.createOrder(body);
        return ResponseEntity.created(URI.create("/orders/" + order.getId())).build();
    }
}
