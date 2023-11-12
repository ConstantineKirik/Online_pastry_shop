package com.academy.kirik.online_pastry_shop.model.repository;

import com.academy.kirik.online_pastry_shop.model.entity.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepository extends JpaRepository<BlackList, Integer> {
}
