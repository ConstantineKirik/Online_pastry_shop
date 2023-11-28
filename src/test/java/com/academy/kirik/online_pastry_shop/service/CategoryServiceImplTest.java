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
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    CategoryService categoryService;

    @MockBean
    CategoryRepository categoryRepository;

    @Test
    public void getAllTest() {
        List<Category> expectedCategories = new ArrayList<>();
        Mockito.when(categoryRepository.findAll()).thenReturn(expectedCategories);

        List<Category> actualCategories = categoryService.getAll();

        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    public void getByTitleTest() {
        String title = "Test";
        Category expectedCategory = Category.builder().title(title).build();
        Mockito.when(categoryRepository.findByTitle(Mockito.anyString())).thenReturn(expectedCategory);

        Category actualCategory = categoryService.getByTitle(title);

        assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void saveTest(){
        Category category = Category.builder().title("Test").build();

        boolean result = categoryService.save(category);

        assertTrue(result);
    }
}
