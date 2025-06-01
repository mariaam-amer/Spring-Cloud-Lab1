package iti.jets.product_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import iti.jets.product_app.entities.Product;

public interface ProductRepo extends JpaRepository<Product,Long>{
    
}
