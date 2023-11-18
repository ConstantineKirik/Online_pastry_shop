package com.academy.kirik.online_pastry_shop.service.impl;

import com.academy.kirik.online_pastry_shop.dto.DeliveryAddressDTO;
import com.academy.kirik.online_pastry_shop.model.entity.DeliveryAddress;
import com.academy.kirik.online_pastry_shop.model.repository.DeliveryAddressRepository;
import com.academy.kirik.online_pastry_shop.service.DeliveryAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryAddressImpl implements DeliveryAddressService {
    private final DeliveryAddressRepository deliveryAddressRepository;

    @Override
    public void save(DeliveryAddressDTO deliveryAddressDTO) {

        DeliveryAddress deliveryAddressFromDB = deliveryAddressRepository.findByStreetAndHouseAndApartment(
                deliveryAddressDTO.getStreet(),
                deliveryAddressDTO.getHouse(),
                deliveryAddressDTO.getApartment());

        if (deliveryAddressFromDB == null) {
            DeliveryAddress deliveryAddress = DeliveryAddress.builder()
                    .street(deliveryAddressDTO.getStreet())
                    .house(deliveryAddressDTO.getHouse())
                    .apartment(deliveryAddressDTO.getApartment())
                    .build();
            deliveryAddressRepository.save(deliveryAddress);
        }
    }

    @Override
    public Integer getByIdDeliveryAddress(DeliveryAddressDTO deliveryAddressDTO) {
        return deliveryAddressRepository.findByStreetAndHouseAndApartment(deliveryAddressDTO.getStreet(),
                deliveryAddressDTO.getHouse(),
                deliveryAddressDTO.getApartment()).getId();
    }
}
