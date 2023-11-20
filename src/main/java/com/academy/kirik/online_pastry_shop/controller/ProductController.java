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


}
