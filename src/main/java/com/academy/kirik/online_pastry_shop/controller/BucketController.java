package com.academy.kirik.online_pastry_shop.controller;

import com.academy.kirik.online_pastry_shop.dto.BucketDTO;
import com.academy.kirik.online_pastry_shop.model.entity.Bucket;
import com.academy.kirik.online_pastry_shop.model.entity.Product;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.service.BucketService;
import com.academy.kirik.online_pastry_shop.service.ProductService;
import com.academy.kirik.online_pastry_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BucketController {
    private final BucketService bucketService;
    private final ProductService productService;

    @GetMapping("/bucket")
    public String bucket(Model model, Principal principal) {

        BucketDTO bucketDTO = bucketService.getBucketByUser(principal.getName());
        model.addAttribute("bucketDTO", bucketDTO);

        return "bucket";
    }

    @GetMapping("/addBucket")
    public String addBucket(@RequestParam Integer id, Principal principal) {
        productService.addToUserBucket(id, principal.getName());
        return "redirect:/categories";
    }
}
