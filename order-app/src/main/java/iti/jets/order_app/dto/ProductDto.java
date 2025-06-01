package iti.jets.order_app.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    // private Long id;
    private String name;
    private String description;
    private double price;
}