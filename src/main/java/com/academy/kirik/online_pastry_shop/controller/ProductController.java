package com.academy.kirik.online_pastry_shop.controller;

import com.academy.kirik.online_pastry_shop.dto.ProductDTO;
import com.academy.kirik.online_pastry_shop.model.entity.Category;
import com.academy.kirik.online_pastry_shop.model.entity.Product;
import com.academy.kirik.online_pastry_shop.service.ProductService;
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
public class ProductController {
    private final ProductService productService;

    @GetMapping("/addProduct")
    public String addCategory(Model model) {
        model.addAttribute("addProduct", new ProductDTO());
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute("addProduct") ProductDTO productDTO, Model model) {

        if (!productService.save(productDTO)) {
            model.addAttribute("titleError", "Продукт с таким названием уже существует!");
            return "createProduct";
        }

        List<Product> products = productService.findAllByCategory_Title(productDTO.getCategory());
        model.addAttribute("products", products);

        return "categories";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam String title, Model model){

        productService.deleteByTitle(title);


        return "categories";
    }
}
