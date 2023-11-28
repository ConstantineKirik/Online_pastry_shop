package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.DeliveryAddressDTO;
import com.academy.kirik.online_pastry_shop.model.entity.DeliveryAddress;
import com.academy.kirik.online_pastry_shop.model.repository.DeliveryAddressRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DeliveryAddressImplTest {

    @Autowired
    DeliveryAddressService deliveryAddressService;

    @MockBean
    DeliveryAddressRepository deliveryAddressRepository;

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
