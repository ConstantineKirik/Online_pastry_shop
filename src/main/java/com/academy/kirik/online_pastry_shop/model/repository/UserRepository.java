package com.academy.kirik.online_pastry_shop.model.repository;

import com.academy.kirik.online_pastry_shop.enums.UserStatus;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByMobileNumber(Long mobileNumber);

    User findByEmail(String email);

    @Query(value = "SELECT * FROM users WHERE username LIKE :username OR mobile_number LIKE :mobileNumber OR email LIKE :email OR status LIKE :status",
            nativeQuery = true)
    List<User> searchUsers(String username, Long mobileNumber, String email, String status);
}
