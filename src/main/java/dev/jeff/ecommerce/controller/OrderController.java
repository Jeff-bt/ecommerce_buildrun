package dev.jeff.ecommerce.controller;

import dev.jeff.ecommerce.controller.dto.ApiResponseDto;
import dev.jeff.ecommerce.controller.dto.CreateOrderDto;
import dev.jeff.ecommerce.controller.dto.OrderSummaryDto;
import dev.jeff.ecommerce.controller.dto.PaginationResponseDto;
import dev.jeff.ecommerce.entity.OrderEntity;
import dev.jeff.ecommerce.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<ApiResponseDto<OrderSummaryDto>> listOrders(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                      @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                                                                      @RequestParam(name = "orderBy", defaultValue = "desc") String orderBy) {

        Page<OrderSummaryDto> pageResp = orderService.findAll(page, pageSize, orderBy);

        return ResponseEntity.ok(new ApiResponseDto<>(
                pageResp.getContent(),
                new PaginationResponseDto(pageResp.getNumber(), pageResp.getSize(), pageResp.getTotalElements(), pageResp.getTotalPages())
        ));
    }
}
