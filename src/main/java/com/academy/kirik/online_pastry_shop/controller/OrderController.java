package com.academy.kirik.online_pastry_shop.controller;

import com.academy.kirik.online_pastry_shop.dto.BucketDTO;
import com.academy.kirik.online_pastry_shop.dto.DeliveryAddressDTO;
import com.academy.kirik.online_pastry_shop.dto.OrderDTO;
import com.academy.kirik.online_pastry_shop.model.entity.Order;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.service.BucketService;
import com.academy.kirik.online_pastry_shop.service.DeliveryAddressService;
import com.academy.kirik.online_pastry_shop.service.OrderService;
import com.academy.kirik.online_pastry_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final DeliveryAddressService deliveryAddressService;
    private final BucketService bucketService;
    private final OrderService orderService;
    private final UserService userService;

    @GetMapping(value = "/deliveryAddress")
    public String deliveryAddress(Model model) {
        model.addAttribute("deliveryAddress", new DeliveryAddressDTO());
        return "deliveryAddress";
    }

    @PostMapping(value = "/submitDeliveryAddress")
    public String submitDeliveryAddress(@ModelAttribute("deliveryAddress") DeliveryAddressDTO deliveryAddressDTO, Model model, Principal principal) {

        deliveryAddressService.save(deliveryAddressDTO);
        BucketDTO bucketDTO = bucketService.getBucketByUser(principal.getName());

        model.addAttribute("bucket", bucketDTO);
        model.addAttribute("deliveryAddress", deliveryAddressDTO);
        model.addAttribute("order", new OrderDTO());
        model.addAttribute("deliveryAddressId", deliveryAddressService.getIdDeliveryAddress(deliveryAddressDTO));

        return "confirmOrder";
    }

    @PostMapping(value = "/createOrder")
    public String createOrder(@ModelAttribute("order") OrderDTO orderDTO, Principal principal) {

        orderService.createOrder(orderDTO, principal.getName());
        bucketService.clearBucket(userService.getByUsername(principal.getName()));

        return "createOrder";
    }

    @GetMapping(value = "/orders")
    public String orders(Model model,Principal principal) {
        User user = userService.getByUsername(principal.getName());
        List<Order> orders = user.getOrders();

        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping(value = "/detailsOrder")
    public String detailsOrder(@RequestParam Integer id, Model model) {
        Order order = orderService.getById(id);
        model.addAttribute("order", order);
        return "detailsOrder";
    }
}
