package dev.jeff.ecommerce.controller.dto;

public record CreateUserDto(String fullName,
                            CreateBillingAddressDto billingAddress) {
}
