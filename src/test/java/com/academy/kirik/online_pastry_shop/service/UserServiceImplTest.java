package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.UserDTO;
import com.academy.kirik.online_pastry_shop.enums.UserStatus;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.model.repository.UserRepository;
import com.academy.kirik.online_pastry_shop.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Test
    public void getByIdTest(){
        Integer id = 1;
        User expectedUser = User.builder().id(id).build();
        Mockito.when(userRepository.getReferenceById(Mockito.anyInt())).thenReturn(expectedUser);

        User actualUser = userService.getById(id);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void getByUsernameTest(){
        String username = "Test";
        User expectedUser = User.builder().username(username).build();
        Mockito.when(userRepository.findByUsername(Mockito.anyString())).thenReturn(expectedUser);

        User actualUser = userService.getByUsername(username);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void getAllByStatusTest() {
        List<User> usersFromMock = new ArrayList<>();
        Mockito.when(userRepository.findAllByStatus(UserStatus.STAFF)).thenReturn(usersFromMock);

        List<User> users = userService.getAllByStatus(UserStatus.STAFF);

        assertEquals(users, usersFromMock);
    }

    @Test
    void saveTest(){
        UserDTO userDTO = UserDTO.builder()
                .username("name")
                .email("email")
                .password("password")
                .confirmPassword("password")
                .build();

        Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenReturn("password");

        boolean result = userService.save(userDTO);

        assertTrue(result);
        Mockito.verify(passwordEncoder).encode(Mockito.anyString());
        Mockito.verify(userRepository).save(Mockito.any());
    }
}
