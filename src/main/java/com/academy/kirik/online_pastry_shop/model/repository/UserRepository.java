package com.academy.kirik.online_pastry_shop.model.repository;

import com.academy.kirik.online_pastry_shop.enums.UserStatus;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByMobileNumber(Long mobileNumber);

    User findByEmail(String email);

    List<User> findAllByStatus(UserStatus status);
}
