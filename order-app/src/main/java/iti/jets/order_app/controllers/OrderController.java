package iti.jets.order_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iti.jets.order_app.dto.OrderDto;
import iti.jets.order_app.dto.ProductDto;
import iti.jets.order_app.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // POST: http://localhost:8082/orders
    // Body :
    // {
    // "userId":1,
    // "productId" : 1,
    // "quantity": 3
    // }
    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto dto) {
        return ResponseEntity.ok(orderService.createOrder(dto));
    }
    
    // Get: http://localhost:8082/orders/1
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    // Get: http://localhost:8082/orders/users/1
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<OrderDto>> getOrdersByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }

    // Get: http://localhost:8082/orders/1/product
    // Get Product detail by Order Id
    @GetMapping("/{orderId}/product")
    public ResponseEntity<Object> getProductByOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getProductByOrderId(orderId));
    }
}
