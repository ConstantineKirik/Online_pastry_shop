package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.model.entity.Category;
import com.academy.kirik.online_pastry_shop.model.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    CategoryService categoryService;

    @MockBean
    CategoryRepository categoryRepositoryMock;

    @Test
    public void getAllTest() {
        List<Category> categoriesFromMock = new ArrayList<>();
        Mockito.when(categoryRepositoryMock.findAll()).thenReturn(categoriesFromMock);

        List<Category> categories = categoryService.getAll();

        assertEquals(categories, categoriesFromMock);
    }

    @Test
    public void getByTitleTest() {
        Category categoryFromMock = new Category();
        Mockito.when(categoryRepositoryMock.findByTitle("Эклеры")).thenReturn(categoryFromMock);

        Category category = categoryService.getByTitle("Эклеры");

        assertEquals(category, categoryFromMock);
    }
}
