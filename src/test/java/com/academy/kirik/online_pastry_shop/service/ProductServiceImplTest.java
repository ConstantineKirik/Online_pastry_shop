package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.model.entity.Product;
import com.academy.kirik.online_pastry_shop.model.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @MockBean
    ProductRepository productRepositoryMock;

    @Test
    public void getByIdTest() {
        Product productFromMock = new Product();
        Mockito.when(productRepositoryMock.getReferenceById(1)).thenReturn(productFromMock);

        Product product = productService.getById(1);

        assertEquals(product, productFromMock);
    }

    @Test
    public void getAllTest() {
        List<Product> productsFromMock = new ArrayList<>();
        Mockito.when(productRepositoryMock.findAll()).thenReturn(productsFromMock);

        List<Product> products = productService.getAll();

        assertEquals(products, productsFromMock);
    }

    @Test
    public void popularTest(){
        List<Integer> productsFromMock = new ArrayList<>();
        Mockito.when(productRepositoryMock.popular()).thenReturn(productsFromMock);

        List<Integer> products = productService.popular().stream().map(Product::getId).collect(Collectors.toList());;

        assertEquals(products, productsFromMock);
    }
}
