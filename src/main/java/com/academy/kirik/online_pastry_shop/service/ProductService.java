package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.model.entity.Category;
import com.academy.kirik.online_pastry_shop.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getByTitle(String title);
}
