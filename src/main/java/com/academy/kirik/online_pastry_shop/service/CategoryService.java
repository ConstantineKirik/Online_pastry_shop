package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    Category getByTitle(String title);
}
