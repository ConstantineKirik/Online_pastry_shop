package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.ProductDTO;
import com.academy.kirik.online_pastry_shop.model.entity.Category;
import com.academy.kirik.online_pastry_shop.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllByCategory_Title(String categoryTitle);

    Product getByTitle(String title);

    boolean save(ProductDTO productDTO);

    void deleteByTitle(String title);
}
