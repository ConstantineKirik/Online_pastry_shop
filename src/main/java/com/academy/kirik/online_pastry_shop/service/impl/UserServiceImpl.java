package com.academy.kirik.online_pastry_shop.service.impl;

import com.academy.kirik.online_pastry_shop.dto.UserDTO;
import com.academy.kirik.online_pastry_shop.model.entity.Bucket;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.enums.Role;
import com.academy.kirik.online_pastry_shop.enums.UserStatus;
import com.academy.kirik.online_pastry_shop.model.repository.UserRepository;
import com.academy.kirik.online_pastry_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean save(UserDTO userDTO) {

        User userFromDB = userRepository.findByUsername(userDTO.getUsername());
        if (userFromDB != null) {
            return false;
        }

        User user = User.builder()
                .username(userDTO.getUsername())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .role(Role.CLIENT)
                .mobileNumber(userDTO.getMobileNumber())
                .email(userDTO.getEmail())
                .status(UserStatus.BASIC)
                .build();

        userRepository.save(user);
        return true;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User" + username + " not found");
        }

        return user;
    }
}
