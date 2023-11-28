package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.enums.OrderStatus;
import com.academy.kirik.online_pastry_shop.model.entity.Order;
import com.academy.kirik.online_pastry_shop.model.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @MockBean
    OrderRepository orderRepository;

    @Test
    public void getByIdTest(){
        Integer id = 1;
        Order expectedOrder = Order.builder().id(id).build();
        Mockito.when(orderRepository.findOrderById(Mockito.anyInt())).thenReturn(expectedOrder);

        Order actualOrder = orderService.getById(id);

        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void getByStatusTest(){
        List<Order> ordersFromMock = new ArrayList<>();
        Mockito.when(orderRepository.findOrdersByStatus(OrderStatus.NEW)).thenReturn(ordersFromMock);

        List<Order> orders = orderService.getByStatus(OrderStatus.NEW);

        assertEquals(orders, ordersFromMock);
    }
}
