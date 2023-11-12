package com.academy.kirik.online_pastry_shop.model.repository;

import com.academy.kirik.online_pastry_shop.model.entity.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Integer> {
}
