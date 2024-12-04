package dev.jeff.ecommerce.controller.dto;

import dev.jeff.ecommerce.entity.BillingAddressEntity;

public record CreateBillingAddressDto(String address,
                                      String number,
                                      String complement) {

    public static BillingAddressEntity toEntity(CreateBillingAddressDto dto){
        BillingAddressEntity billingAddress = new BillingAddressEntity();
        billingAddress.setAddress(dto.address());
        billingAddress.setNumber(dto.number());
        billingAddress.setComplement(dto.complement());

        return billingAddress;
    }
}
