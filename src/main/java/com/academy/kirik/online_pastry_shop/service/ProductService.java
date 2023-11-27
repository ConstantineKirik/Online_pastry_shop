package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.ProductDTO;
import com.academy.kirik.online_pastry_shop.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    boolean save(ProductDTO productDTO);

    Product getById(Integer id);

    void updateProduct(Integer id, ProductDTO productDTO);

    void removeProduct(Integer id);

    void addToUserBucket(Integer productId, String username);

    List<Product> popular();
}
