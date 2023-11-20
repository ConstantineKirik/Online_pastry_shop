package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.UserDTO;
import com.academy.kirik.online_pastry_shop.enums.Role;
import com.academy.kirik.online_pastry_shop.enums.UserStatus;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void save(User user);

    boolean save(UserDTO userDTO);

    User getById(Integer id);

    User getByUsername(String username);

    List<User> getAllByStatus(UserStatus status);

    List<User> getAllClient();

    void updateUserRole(Integer id, Role role);

    void updateUserStatus(Integer id, UserStatus status);
}
