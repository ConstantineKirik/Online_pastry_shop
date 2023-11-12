package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);

    boolean save(String username, String password, Long mobileNumber, String email);

    List<User> getAll();
}
