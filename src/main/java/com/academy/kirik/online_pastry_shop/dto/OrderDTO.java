package com.academy.kirik.online_pastry_shop.dto;

import lombok.Data;

@Data
public class OrderDTO {

    private Double amount;
    private Integer deliveryAddressesId;
}
