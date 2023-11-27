package com.academy.kirik.online_pastry_shop.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String title;
    private String category;
    private String description;
    private Double price;
    private String image;
}
