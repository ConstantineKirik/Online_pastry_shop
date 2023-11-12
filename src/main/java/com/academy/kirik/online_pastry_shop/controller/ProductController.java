package com.academy.kirik.online_pastry_shop.controller;

import com.academy.kirik.online_pastry_shop.model.entity.Product;
import com.academy.kirik.online_pastry_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public String getAll(Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "products";
    }
}
