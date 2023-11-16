package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.model.entity.Category;

import java.util.List;

public interface CategoryService {

    boolean save(Category category);

    Category getByTitle(String title);

    List<Category> getAll();

    void deleteById(Integer id);
}
