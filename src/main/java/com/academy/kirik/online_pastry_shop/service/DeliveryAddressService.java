package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.DeliveryAddressDTO;
import com.academy.kirik.online_pastry_shop.model.entity.DeliveryAddress;

public interface DeliveryAddressService {
    void save(DeliveryAddressDTO deliveryAddressDTO);

    Integer getByIdDeliveryAddress(DeliveryAddressDTO deliveryAddressDTO);
}
