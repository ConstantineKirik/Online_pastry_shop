package com.academy.kirik.online_pastry_shop.model.repository;

import com.academy.kirik.online_pastry_shop.model.entity.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Integer> {

    DeliveryAddress findByStreetAndHouseAndApartment(String street,String house, String apartment);
    DeliveryAddress findDeliveryAddressById(Integer id);
}
