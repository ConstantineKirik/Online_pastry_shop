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
@Table(name = "buckets")
public class Bucket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_buckets",
            joinColumns = {@JoinColumn(name = "buckets_id")},
            inverseJoinColumns = {@JoinColumn(name = "products_id")}
    )
    private List<Product> products;
    @Column
    private Double amount;
}
