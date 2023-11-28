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
public class MainController {

    private final ProductService productService;

    @GetMapping(value = "/")
    public String popular(Model model) {
        List<Product> popular = productService.popular();
        model.addAttribute("popular", popular);
        return "mainPage";
    }
}
