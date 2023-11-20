package com.academy.kirik.online_pastry_shop.controller;

import com.academy.kirik.online_pastry_shop.dto.ProductDTO;
import com.academy.kirik.online_pastry_shop.model.entity.Category;
import com.academy.kirik.online_pastry_shop.model.entity.Product;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.service.CategoryService;
import com.academy.kirik.online_pastry_shop.service.OrderService;
import com.academy.kirik.online_pastry_shop.service.ProductService;
import com.academy.kirik.online_pastry_shop.service.UserService;
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
public class AdminController {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final OrderService orderService;

    @GetMapping(value = "/showAllClient")
    public String showAllClient(Model model) {

        List<User> users = userService.getAllClient();
        model.addAttribute("users", users);

        return "userManagement";
    }

    @GetMapping(value = "/showAllUsers")
    public String showAllUsersByStatus(@RequestParam String status, Model model) {

        List<User> usersWithStatus = userService.getAllByStatus(status);
        model.addAttribute("usersWithStatus", usersWithStatus);

        return "userManagement";
    }

    @GetMapping(value = "/productManagement")
    public String productManagement(Model model) {

        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);

        List<Product> products = productService.getAll();
        model.addAttribute("products", products);

        return "productManagement";
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

        return "redirect:/productManagement";
    }

    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam Integer id){
        categoryService.deleteById(id);
        return "redirect:/productManagement";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("addProduct", new ProductDTO());
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute("addProduct") ProductDTO productDTO, Model model) {

        if (!productService.save(productDTO)) {
            model.addAttribute("titleError", "Продукт с таким названием уже существует!");
            return "createProduct";
        }

        return "redirect:/productManagement";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam Integer id){
        productService.deleteById(id);
        return "redirect:/productManagement";
    }

    @GetMapping(value = "/orderManagement")
    public String orderManagement(Model model) {


        return "orderManagement";
    }
}
