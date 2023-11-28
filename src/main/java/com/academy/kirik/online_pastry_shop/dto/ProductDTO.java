package com.academy.kirik.online_pastry_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String title;
    private String category;
    private String description;
    private Double price;
    private String image;
}
