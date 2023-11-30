package com.academy.kirik.online_pastry_shop.controller;

import com.academy.kirik.online_pastry_shop.enums.OrderStatus;
import com.academy.kirik.online_pastry_shop.model.entity.Order;
import com.academy.kirik.online_pastry_shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/staff")
public class StaffController {

    private final OrderService orderService;

    @GetMapping(value = "/orderManagement")
    public String orderManagement(Model model) {
        List<Order> newOrders = orderService.getByStatus(OrderStatus.NEW);
        model.addAttribute("newOrders", newOrders);

        List<Order> acceptOrders = orderService.getByStatus(OrderStatus.ACCEPTED);
        model.addAttribute("acceptOrders", acceptOrders);

        List<Order> formedOrders = orderService.getByStatus(OrderStatus.FORMED);
        model.addAttribute("formedOrders", formedOrders);

        List<Order> sentOrders = orderService.getByStatus(OrderStatus.SENT);
        model.addAttribute("sentOrders", sentOrders);

        List<Order> deliveredOrders = orderService.getByStatus(OrderStatus.DELIVERED);
        model.addAttribute("deliveredOrders", deliveredOrders);
        return "orderManagement";
    }

    @GetMapping(value = "/acceptOrder")
    public String acceptOrder(@RequestParam Integer id) {

        orderService.updateStatusOrder(id, OrderStatus.ACCEPTED);

        return "redirect:/staff/orderManagement";
    }

    @GetMapping(value = "/formedOrder")
    public String formedOrder(@RequestParam Integer id) {

        orderService.updateStatusOrder(id, OrderStatus.FORMED);

        return "redirect:/staff/orderManagement";
    }

    @GetMapping(value = "/sentOrder")
    public String sentOrder(@RequestParam Integer id) {

        orderService.updateStatusOrder(id, OrderStatus.SENT);

        return "redirect:/staff/orderManagement";
    }

    @GetMapping(value = "/deliveredOrder")
    public String deliveredOrder(@RequestParam Integer id) {

        orderService.updateStatusOrder(id, OrderStatus.DELIVERED);

        return "redirect:/staff/orderManagement";
    }

    @GetMapping(value = "/closeOrder")
    public String closeOrder(@RequestParam Integer id) {

        orderService.updateStatusOrder(id, OrderStatus.CLOSED);

        return "redirect:/staff/orderManagement";
    }
}
