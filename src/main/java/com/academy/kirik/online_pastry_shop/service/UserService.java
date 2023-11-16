package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.UserDTO;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    boolean save(UserDTO userDTO);

    void save(User user);

    User findByUsername(String username);
}
