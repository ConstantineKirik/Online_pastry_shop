package com.academy.kirik.online_pastry_shop.controller;

import com.academy.kirik.online_pastry_shop.model.entity.Category;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public String getAll(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/category")
    public String get(@RequestParam String title, Model model){
        Category category = categoryService.getByTitle(title);
        model.addAttribute("category", category);
        return "category";
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        model.addAttribute("addCategory", new Category());
        return "createCategory";
    }

    @PostMapping("/createCategory")
    public String createCategory(@ModelAttribute("addCategory") Category category, Model model) {

        if (!categoryService.save(category)) {
            model.addAttribute("titleError", "Категория с таким названием уже существует!");
            return "createCategory";
        }

        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);

        return "categories";
    }

    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam String title, Model model){
        categoryService.deleteByTitle(title);

        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "categories";
    }
}
