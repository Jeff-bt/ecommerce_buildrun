package dev.jeff.ecommerce.controller;

import dev.jeff.ecommerce.controller.dto.CreateUserDto;
import dev.jeff.ecommerce.entity.UserEntity;
import dev.jeff.ecommerce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/{usersId}")
    public ResponseEntity<UserEntity> findById(@PathVariable("usersId") UUID usersId) {
        Optional<UserEntity> user = userService.findById(usersId);

        return user.isPresent() ?
                ResponseEntity.ok(user.get()) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{usersId}")
    public ResponseEntity<Void> deleteById(@PathVariable("usersId") UUID usersId) {
        boolean hasUser = userService.delete(usersId);

        return hasUser ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
