package com.academy.kirik.online_pastry_shop.model.repository;

import com.academy.kirik.online_pastry_shop.enums.Role;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);

    User findByUsername(String username);

    List<User> findAllByRole(Role role);

    List<User> findAllByStatus(String status);
}
