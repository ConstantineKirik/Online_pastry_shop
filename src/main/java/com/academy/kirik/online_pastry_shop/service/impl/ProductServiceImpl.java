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

import java.util.Collections;
import java.util.List;

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
                .build();

        productRepository.save(product);
        return true;
    }

    @Override
    public Product getByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    @Override
    public List<Product> findAllByCategory_Title(String categoryTitle) {
        return productRepository.findAllByCategory_Title(categoryTitle);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addToUserBucket(Integer productId, String username) {
        User user = userService.getByUsername(username);

        Bucket bucket = user.getBucket();
        if(bucket == null){
            Bucket newBucket = bucketService.createBucket(user, Collections.singletonList(productId));
            user.setBucket(newBucket);
            userService.save(user);
        } else {
            bucketService.addProduct(bucket, Collections.singletonList(productId));
        }
    }
}
