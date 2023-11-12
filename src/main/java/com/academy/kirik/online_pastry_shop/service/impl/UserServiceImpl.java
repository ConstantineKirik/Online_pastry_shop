package com.academy.kirik.online_pastry_shop.service.impl;

import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.model.entity.enums.Role;
import com.academy.kirik.online_pastry_shop.model.repository.UserRepository;
import com.academy.kirik.online_pastry_shop.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User" + username + " not found");
        }

        return user;
    }

    @Override
    public boolean save(String username, String password, Long mobileNumber, String email) {

        User userFromDB = userRepository.findByUsername(username);
        if (userFromDB != null) {
            return false;
        }

        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(Role.CLIENT)
                .mobileNumber(mobileNumber)
                .email(email)
                .build();

        userRepository.save(user);
        return true;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
