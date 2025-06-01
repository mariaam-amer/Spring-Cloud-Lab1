package iti.jets.order_app.mappers;

import org.mapstruct.Mapper;

import iti.jets.order_app.dto.OrderDto;
import iti.jets.order_app.entities.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    
    public Order toEntity(OrderDto orderDto);
    public OrderDto toDto(Order order);
}
