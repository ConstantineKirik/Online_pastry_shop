package com.academy.kirik.online_pastry_shop.controller;

import com.academy.kirik.online_pastry_shop.dto.ProductDTO;
import com.academy.kirik.online_pastry_shop.dto.UserDTO;
import com.academy.kirik.online_pastry_shop.enums.Role;
import com.academy.kirik.online_pastry_shop.enums.UserStatus;
import com.academy.kirik.online_pastry_shop.model.entity.Category;
import com.academy.kirik.online_pastry_shop.model.entity.Product;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.service.CategoryService;
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

    @GetMapping(value = "/showAllUsers")
    public String showAllUsers(@RequestParam String status, Model model) {

        List<User> users = userService.getAllByStatus(UserStatus.valueOf(status));
        model.addAttribute("users", users);

        return "userManagement";
    }

    @GetMapping(value = "/showUserDetails")
    public String showUserDetails(@RequestParam Integer id, Model model) {

        User user = userService.getById(id);
        model.addAttribute("user", user);
        model.addAttribute("change", new UserDTO());

        return "userDetails";
    }

    @PostMapping(value = "/statusUp")
    public String statusUp(@ModelAttribute("change") UserDTO userDTO, @RequestParam Integer id){

        userService.updateUserStatus(id, UserStatus.valueOf(userDTO.getStatus()));
        return "userManagement";
    }

    @PostMapping(value = "/assignRole")
    public String assignRole(@ModelAttribute("change") UserDTO userDTO, @RequestParam Integer id){

        userService.updateUserRole(id, Role.valueOf(userDTO.getRole()));
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
}
