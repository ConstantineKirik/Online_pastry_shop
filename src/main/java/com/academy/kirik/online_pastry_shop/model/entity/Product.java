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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String title;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    @Column
    private String description;
    @Column
    private Double price;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_orders",
            joinColumns = {@JoinColumn(name = "products_id")},
            inverseJoinColumns = {@JoinColumn(name = "orders_id")}
    )
    private List<Order> orders;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_buckets",
            joinColumns = {@JoinColumn(name = "products_id")},
            inverseJoinColumns = {@JoinColumn(name = "buckets_id")}
    )
    private List<Bucket> buckets;
}
