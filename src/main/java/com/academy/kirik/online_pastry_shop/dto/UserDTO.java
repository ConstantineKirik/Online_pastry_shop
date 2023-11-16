package com.academy.kirik.online_pastry_shop.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String password;
    private String confirmPassword;
    private Long mobileNumber;
    private String email;
}
