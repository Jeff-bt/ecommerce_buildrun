package dev.jeff.ecommerce.controller;

import dev.jeff.ecommerce.controller.dto.CreateUserDto;
import dev.jeff.ecommerce.entity.UserEntity;
import dev.jeff.ecommerce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUserDto body) {
        UserEntity user = userService.create(body);
        return ResponseEntity.created(URI.create("/users/" + user.getUserId())).build();
    }
}
