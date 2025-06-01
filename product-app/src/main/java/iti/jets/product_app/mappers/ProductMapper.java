package iti.jets.product_app.mappers;

import org.mapstruct.Mapper;

import iti.jets.product_app.dto.ProductDto;
import iti.jets.product_app.entities.Product;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    public Product toEntity (ProductDto ProductDto);
    public ProductDto toDto(Product product);
}
