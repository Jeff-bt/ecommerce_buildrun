package dev.jeff.ecommerce.service;

import dev.jeff.ecommerce.controller.dto.CreateBillingAddressDto;
import dev.jeff.ecommerce.controller.dto.CreateUserDto;
import dev.jeff.ecommerce.entity.UserEntity;
import dev.jeff.ecommerce.repository.BillingAddressRepository;
import dev.jeff.ecommerce.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository, BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }


    public UserEntity create(CreateUserDto body) {
        UserEntity user = new UserEntity();
        user.setFullName(body.fullName());
        user.setBillingAddress(CreateBillingAddressDto.toEntity(body.billingAddress()));
        return userRepository.save(user);
    }
}
