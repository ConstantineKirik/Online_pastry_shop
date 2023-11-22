package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.DeliveryAddressDTO;

public interface DeliveryAddressService {
    void save(DeliveryAddressDTO deliveryAddressDTO);

    Integer getIdDeliveryAddress(DeliveryAddressDTO deliveryAddressDTO);
}
