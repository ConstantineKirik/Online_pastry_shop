package com.academy.kirik.online_pastry_shop.model.repository;

import com.academy.kirik.online_pastry_shop.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByTitle(String title);

    @Query(value = "SELECT product_id FROM products_orders GROUP BY product_id ORDER BY count(order_id) DESC LIMIT 4",
            nativeQuery = true)
    List<Integer> popular();
}
