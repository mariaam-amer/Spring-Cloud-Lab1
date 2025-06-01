package iti.jets.order_app.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import iti.jets.order_app.entities.Order;

public interface OrderRepo extends JpaRepository<Order,Long>{
    public Optional<Order> findByUserId(Long userId);
}
