package com.academy.kirik.online_pastry_shop.controller;

import com.academy.kirik.online_pastry_shop.dto.BucketDTO;
import com.academy.kirik.online_pastry_shop.service.BucketService;
import com.academy.kirik.online_pastry_shop.service.ProductService;
import com.academy.kirik.online_pastry_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class BucketController {

    private final UserService userService;
    private final BucketService bucketService;
    private final ProductService productService;
    private final CatalogController catalogController;

    @GetMapping("/bucket")
    public String bucket(Model model, Principal principal) {

        BucketDTO bucketDTO = bucketService.getBucketByUser(principal.getName());
        model.addAttribute("bucketDTO", bucketDTO);

        return "bucket";
    }

    @GetMapping("/addBucket")
    public String addBucket(@RequestParam Integer id, @RequestParam String title, Principal principal, Model model) {
        productService.addToUserBucket(id, principal.getName());

        return catalogController.getProductsByCategory(title, model);
    }

    @GetMapping("/clearBucket")
    public String clearBucket(Model model, Principal principal) {

        bucketService.clearBucket(userService.getByUsername(principal.getName()));

        BucketDTO bucketDTO = bucketService.getBucketByUser(principal.getName());
        model.addAttribute("bucketDTO", bucketDTO);

        return "bucket";
    }
}
