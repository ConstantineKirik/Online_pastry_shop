package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.UserDTO;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void save(User user);

    boolean save(UserDTO userDTO);

    User findByUsername(String username);

    List<User> getAllByStatus(String status);

    List<User> getAllClient();

    void updateUserStatus(User user, String status);
}
