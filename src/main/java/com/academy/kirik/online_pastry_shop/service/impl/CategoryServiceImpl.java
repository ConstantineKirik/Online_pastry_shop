package com.academy.kirik.online_pastry_shop.service.impl;

import com.academy.kirik.online_pastry_shop.model.entity.Category;
import com.academy.kirik.online_pastry_shop.model.repository.CategoryRepository;
import com.academy.kirik.online_pastry_shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
}
