package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.ProductDTO;
import com.academy.kirik.online_pastry_shop.model.entity.Product;
import com.academy.kirik.online_pastry_shop.model.repository.CategoryRepository;
import com.academy.kirik.online_pastry_shop.model.repository.ProductRepository;
import com.academy.kirik.online_pastry_shop.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceImplTest {

    private ProductService productService;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
        CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);
        UserService userService = Mockito.mock(UserService.class);
        BucketService bucketService = Mockito.mock(BucketService.class);

        productService = new ProductServiceImpl(productRepository, categoryRepository, userService, bucketService);
    }

    @Test
    public void getByIdTest() {
        Integer id = 1;
        Product expectedProduct = Product.builder().id(id).build();
        Mockito.when(productRepository.getReferenceById(Mockito.anyInt())).thenReturn(expectedProduct);

        Product actualProduct = productService.getById(id);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void getAllTest() {
        List<Product> expectedProducts = new ArrayList<>();
        Mockito.when(productRepository.findAll()).thenReturn(expectedProducts);

        List<Product> actualProducts = productService.getAll();

        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    public void popularTest() {
        List<Integer> expectedProducts = new ArrayList<>();
        Mockito.when(productRepository.popular()).thenReturn(expectedProducts);

        List<Integer> actualProducts = productService.popular().stream().map(Product::getId).collect(Collectors.toList());

        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    void saveTrueTest() {
        ProductDTO productDTO = ProductDTO.builder().title("Title").build();
        Mockito.when(productRepository.findByTitle(Mockito.anyString())).thenReturn(null);

        boolean result = productService.save(productDTO);

        assertTrue(result);
    }

    @Test
    void saveFalseTest() {
        ProductDTO productDTO = ProductDTO.builder().title("Title").build();
        Product product = Product.builder().title("Title").build();
        Mockito.when(productRepository.findByTitle(Mockito.anyString())).thenReturn(product);

        boolean result = productService.save(productDTO);

        assertFalse(result);
    }

    @Test
    public void updateProductTest() {
        Integer id = 1;
        String Before = "Before";
        String After = "After";
        Product product = Product.builder().title(Before).build();
        ProductDTO productDTO = ProductDTO.builder().title(After).build();
        Mockito.when(productRepository.getReferenceById(Mockito.anyInt())).thenReturn(product);

        productService.updateProduct(id, productDTO);

        assertEquals(After, product.getTitle());
    }
}
