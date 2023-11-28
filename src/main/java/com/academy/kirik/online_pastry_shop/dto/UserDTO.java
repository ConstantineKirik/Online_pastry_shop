package com.academy.kirik.online_pastry_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String username;
    private String password;
    private String confirmPassword;
    private Long mobileNumber;
    private String email;
    private String role;
    private String status;
}
