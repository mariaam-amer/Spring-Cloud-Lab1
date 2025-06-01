package iti.jets.order_app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import iti.jets.order_app.dto.OrderDto;
import iti.jets.order_app.dto.ProductDto;
import iti.jets.order_app.entities.Order;
import iti.jets.order_app.mappers.OrderMapper;
import iti.jets.order_app.repos.OrderRepo;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    RestTemplate restTemplate;

    public OrderDto createOrder(OrderDto dto) {
        Order order = orderMapper.toEntity(dto);
        return orderMapper.toDto(orderRepo.save(order));
    }

    public OrderDto getOrderById(Long id) {
        return orderRepo.findById(id)
                .map(orderMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<OrderDto> getOrdersByUser(Long userId) {
        return orderRepo.findByUserId(userId)
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    public Object getProductByOrderId(Long orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return restTemplate.getForObject("http://localhost:8083/products/" + order.getProductId(), Object.class);
    }

    
}
