package com.academy.kirik.online_pastry_shop.service.impl;

import com.academy.kirik.online_pastry_shop.dto.ProductDTO;
import com.academy.kirik.online_pastry_shop.model.entity.Bucket;
import com.academy.kirik.online_pastry_shop.model.entity.Product;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.model.repository.CategoryRepository;
import com.academy.kirik.online_pastry_shop.model.repository.ProductRepository;
import com.academy.kirik.online_pastry_shop.service.BucketService;
import com.academy.kirik.online_pastry_shop.service.ProductService;
import com.academy.kirik.online_pastry_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserService userService;
    private final BucketService bucketService;

    @Override
    public boolean save(ProductDTO productDTO) {
        Product productFromDB = productRepository.findByTitle(productDTO.getTitle());
        if (productFromDB != null) {
            return false;
        }

        Product product = Product.builder()
                .title(productDTO.getTitle())
                .category(categoryRepository.findByTitle(productDTO.getCategory()))
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .image(productDTO.getImage())
                .build();

        productRepository.save(product);
        return true;
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.getReferenceById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void updateProduct(Integer id, ProductDTO productDTO) {
        Product product = productRepository.getReferenceById(id);

        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        productRepository.save(product);
    }

    @Override
    @Transactional
    public void removeProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addToUserBucket(Integer productId, String username) {
        User user = userService.getByUsername(username);

        Bucket bucket = user.getBucket();
        if (bucket == null) {
            Bucket newBucket = bucketService.createBucket(user, Collections.singletonList(productId));
            user.setBucket(newBucket);
            userService.save(user);
        } else {
            bucketService.addProduct(bucket, Collections.singletonList(productId));
        }
    }

    @Override
    public List<Product> popular() {
        return productRepository.popular().stream()
                .map(productRepository::getReferenceById)
                .collect(Collectors.toList());
    }
}
