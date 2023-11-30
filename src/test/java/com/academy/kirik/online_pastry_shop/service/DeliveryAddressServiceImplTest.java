package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.DeliveryAddressDTO;
import com.academy.kirik.online_pastry_shop.model.entity.DeliveryAddress;
import com.academy.kirik.online_pastry_shop.model.repository.DeliveryAddressRepository;
import com.academy.kirik.online_pastry_shop.service.impl.DeliveryAddressServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryAddressServiceImplTest {

    private DeliveryAddressService deliveryAddressService;
    private DeliveryAddressRepository deliveryAddressRepository;

    @BeforeEach
    void setUp() {
        deliveryAddressRepository = Mockito.mock(DeliveryAddressRepository.class);

        deliveryAddressService = new DeliveryAddressServiceImpl(deliveryAddressRepository);
    }

    @Test
    public void getIdDeliveryAddressTest() {
        Integer id = 1;
        DeliveryAddress deliveryAddress = DeliveryAddress.builder().id(id).build();
        DeliveryAddressDTO deliveryAddressDTO = DeliveryAddressDTO.builder()
                .street("Test")
                .house("Test")
                .apartment("Test")
                .build();
        Mockito.when(deliveryAddressRepository.findByStreetAndHouseAndApartment(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString())).thenReturn(deliveryAddress);

        Integer actualId = deliveryAddressService.getIdDeliveryAddress(deliveryAddressDTO);

        assertEquals(deliveryAddress.getId(), actualId);
    }
}
