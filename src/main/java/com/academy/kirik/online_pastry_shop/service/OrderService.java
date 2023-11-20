package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.OrderDTO;
import com.academy.kirik.online_pastry_shop.enums.OrderStatus;
import com.academy.kirik.online_pastry_shop.model.entity.Order;
import com.academy.kirik.online_pastry_shop.model.entity.User;

import java.util.List;

public interface OrderService {

    Order getById(Integer id);

    void createOrder(OrderDTO orderDTO, String username);

    List<Order> getByStatus(OrderStatus status);

    void updateOrderStatus(Integer id, OrderStatus status);
}
