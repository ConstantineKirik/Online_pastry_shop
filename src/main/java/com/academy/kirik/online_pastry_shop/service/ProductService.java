package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.ProductDTO;
import com.academy.kirik.online_pastry_shop.model.entity.Category;
import com.academy.kirik.online_pastry_shop.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    boolean save(ProductDTO productDTO);

    Product getByTitle(String title);

    List<Product> findAllByCategory_Title(String categoryTitle);

    void deleteById(Integer id);

    void addToUserBucket(Integer productId, String username);
}
