package com.academy.kirik.online_pastry_shop.service.impl;

import com.academy.kirik.online_pastry_shop.model.entity.Category;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.model.entity.enums.Role;
import com.academy.kirik.online_pastry_shop.model.entity.enums.UserStatus;
import com.academy.kirik.online_pastry_shop.model.repository.CategoryRepository;
import com.academy.kirik.online_pastry_shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public boolean save(Category category) {
        Category categoryFromDB = categoryRepository.findByTitle(category.getTitle());
        if (categoryFromDB != null) {
            return false;
        }

        Category newCategory = Category.builder()
                .title(category.getTitle())
                .build();

        categoryRepository.save(newCategory);
        return true;
    }

    @Override
    @Transactional
    public void deleteByTitle(String title) {
        categoryRepository.deleteCategoryByTitle(title);
    }
}
