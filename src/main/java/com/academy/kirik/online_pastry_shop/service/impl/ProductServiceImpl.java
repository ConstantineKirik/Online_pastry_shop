package com.academy.kirik.online_pastry_shop.service.impl;

import com.academy.kirik.online_pastry_shop.dto.ProductDTO;
import com.academy.kirik.online_pastry_shop.model.entity.Product;
import com.academy.kirik.online_pastry_shop.model.repository.CategoryRepository;
import com.academy.kirik.online_pastry_shop.model.repository.ProductRepository;
import com.academy.kirik.online_pastry_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public List<Product> findAllByCategory_Title(String categoryTitle) {
        return productRepository.findAllByCategory_Title(categoryTitle);
    }

    @Override
    public Product getByTitle(String title) {
        return productRepository.findByTitle(title);
    }

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
    @Transactional
    public void deleteByTitle(String title) {
        productRepository.deleteProductByTitle(title);
    }
}
