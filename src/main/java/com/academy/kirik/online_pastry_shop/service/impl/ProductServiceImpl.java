package com.academy.kirik.online_pastry_shop.service.impl;

import com.academy.kirik.online_pastry_shop.model.entity.Category;
import com.academy.kirik.online_pastry_shop.model.entity.Product;
import com.academy.kirik.online_pastry_shop.model.repository.ProductRepository;
import com.academy.kirik.online_pastry_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getByTitle(String title) {
        return productRepository.findByTitle(title);
    }
}
