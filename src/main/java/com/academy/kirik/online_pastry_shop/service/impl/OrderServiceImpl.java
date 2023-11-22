package com.academy.kirik.online_pastry_shop.service.impl;

import com.academy.kirik.online_pastry_shop.dto.OrderDTO;
import com.academy.kirik.online_pastry_shop.enums.OrderStatus;
import com.academy.kirik.online_pastry_shop.model.entity.Order;
import com.academy.kirik.online_pastry_shop.model.entity.Product;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.model.repository.DeliveryAddressRepository;
import com.academy.kirik.online_pastry_shop.model.repository.OrderRepository;
import com.academy.kirik.online_pastry_shop.model.repository.UserRepository;
import com.academy.kirik.online_pastry_shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final UserRepository userRepository;
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final OrderRepository orderRepository;

    @Override
    public Order getById(Integer id) {
        return orderRepository.findOrderById(id);
    }

    @Override
    public void createOrder(OrderDTO orderDTO, String username) {
        User user = userRepository.findByUsername(username);

        Order order = Order.builder()
                .user(user)
                .products(List.copyOf(user.getBucket().getProducts()))
                .amount(orderDTO.getAmount())
                .deliveryAddresses(deliveryAddressRepository.findDeliveryAddressById(orderDTO.getDeliveryAddressesId()))
                .status(OrderStatus.NEW)
                .build();

        orderRepository.save(order);
    }

    @Override
    public List<Order> getByStatus(OrderStatus status) {
        return orderRepository.findOrdersByStatus(status);
    }

    @Override
    public void updateStatusOrder(Integer id, OrderStatus status) {
        Order order = orderRepository.findOrderById(id);

        order.setStatus(status);

        orderRepository.save(order);
    }
}
