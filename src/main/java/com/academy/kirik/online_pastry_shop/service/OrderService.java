package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.OrderDTO;

public interface OrderService {

    void createOrder(OrderDTO orderDTO, String username);
}
