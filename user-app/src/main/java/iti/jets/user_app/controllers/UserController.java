package iti.jets.user_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import iti.jets.user_app.dto.OrderDto;
import iti.jets.user_app.dto.UserDto;
import iti.jets.user_app.repos.UserRepo;
import iti.jets.user_app.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    // POST : http://localhost:8081/users
    // Body :
    // {
    // "username" : "user1",
    // "email" : "user1@gmail.com",
    // "password" : "user1"
    // }
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    // Get: http://localhost:8081/users/1
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Get User orders List by User Id
    // Get: http://localhost:8081/users/1/orders
    @GetMapping("/{id}/orders")
    public ResponseEntity<List<Object>> getUserOrders(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserOrders(id));
    }

}
