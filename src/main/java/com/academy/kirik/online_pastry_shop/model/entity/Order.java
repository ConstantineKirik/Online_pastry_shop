package com.academy.kirik.online_pastry_shop.model.entity;

import com.academy.kirik.online_pastry_shop.model.entity.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_orders",
            joinColumns = {@JoinColumn(name = "orders_id")},
            inverseJoinColumns = {@JoinColumn(name = "products_id")}
    )
    private List<Product> products;
    @Column
    private Double amount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_address")
    private DeliveryAddress deliveryAddresses;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
