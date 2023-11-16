package com.academy.kirik.online_pastry_shop.controller;

import com.academy.kirik.online_pastry_shop.dto.ProductDTO;
import com.academy.kirik.online_pastry_shop.model.entity.Product;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

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

        return "redirect:/categories";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam Integer id){
        productService.deleteById(id);
        return "categories";
    }
}
