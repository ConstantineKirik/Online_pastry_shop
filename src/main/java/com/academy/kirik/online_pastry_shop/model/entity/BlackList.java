package com.academy.kirik.online_pastry_shop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "black_list")
public class BlackList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private List<User> users;
    @CreationTimestamp
    private LocalDateTime dateAdded;
    @Column(name = "reason_added")
    private String reasonAdded;
}
