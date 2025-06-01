package iti.jets.product_app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iti.jets.product_app.dto.ProductDto;
import iti.jets.product_app.entities.Product;
import iti.jets.product_app.mappers.ProductMapper;
import iti.jets.product_app.repos.ProductRepo;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepo ProductRepo;

    @Autowired
    private ProductMapper productMapper;

    public ProductDto addProduct(ProductDto dto) {
        Product product = productMapper.toEntity(dto);
        return productMapper.toDto(ProductRepo.save(product));
    }

    public ProductDto getProductById(Long id) {
        return ProductRepo.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<ProductDto> getAllProducts() {
        return ProductRepo.findAll()
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }
    
}
