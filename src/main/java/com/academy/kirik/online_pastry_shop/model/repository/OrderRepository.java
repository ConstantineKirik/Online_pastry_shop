package com.academy.kirik.online_pastry_shop.model.repository;

import com.academy.kirik.online_pastry_shop.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
