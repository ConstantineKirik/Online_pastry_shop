package com.academy.kirik.online_pastry_shop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "delivery_address")
public class DeliveryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String street;
    @Column
    private String house;
    @Column
    private String apartment;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id")
    private List<Order> orders;
}
