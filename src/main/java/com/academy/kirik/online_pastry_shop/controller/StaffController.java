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
    public String orderManagement() {
        return "orderManagement";
    }

    @GetMapping(value = "/showNewOrders")
    public String showNewOrders(Model model) {

        List<Order> newOrders = orderService.getByStatus(OrderStatus.NEW);
        model.addAttribute("newOrders", newOrders);

        return "orderManagement";
    }

    @GetMapping(value = "/acceptOrder")
    public String acceptOrder(@RequestParam Integer id) {

        orderService.updateStatusOrder(id, OrderStatus.ACCEPTED);

        return "redirect:/staff/showNewOrders";
    }

    @GetMapping(value = "/showAcceptOrders")
    public String showAcceptOrders(Model model) {

        List<Order> acceptOrders = orderService.getByStatus(OrderStatus.ACCEPTED);
        model.addAttribute("acceptOrders", acceptOrders);

        return "orderManagement";
    }

    @GetMapping(value = "/formedOrder")
    public String formedOrder(@RequestParam Integer id) {

        orderService.updateStatusOrder(id, OrderStatus.FORMED);

        return "redirect:/staff/showAcceptOrders";
    }

    @GetMapping(value = "/showFormedOrders")
    public String showFormedOrders(Model model) {

        List<Order> formedOrders = orderService.getByStatus(OrderStatus.FORMED);
        model.addAttribute("formedOrders", formedOrders);

        return "orderManagement";
    }

    @GetMapping(value = "/sentOrder")
    public String sentOrder(@RequestParam Integer id) {

        orderService.updateStatusOrder(id, OrderStatus.SENT);

        return "redirect:/staff/showFormedOrders";
    }

    @GetMapping(value = "/showSentOrders")
    public String showSentOrders(Model model) {

        List<Order> sentOrders = orderService.getByStatus(OrderStatus.SENT);
        model.addAttribute("sentOrders", sentOrders);

        return "orderManagement";
    }

    @GetMapping(value = "/deliveredOrder")
    public String deliveredOrder(@RequestParam Integer id) {

        orderService.updateStatusOrder(id, OrderStatus.DELIVERED);

        return "redirect:/staff/showSentOrders";
    }

    @GetMapping(value = "/showDeliveredOrders")
    public String showDeliveredOrders(Model model) {

        List<Order> deliveredOrders = orderService.getByStatus(OrderStatus.DELIVERED);
        model.addAttribute("deliveredOrders", deliveredOrders);

        return "orderManagement";
    }

    @GetMapping(value = "/closeOrder")
    public String closeOrder(@RequestParam Integer id) {

        orderService.updateStatusOrder(id, OrderStatus.CLOSED);

        return "redirect:/staff/showDeliveredOrders";
    }
}
