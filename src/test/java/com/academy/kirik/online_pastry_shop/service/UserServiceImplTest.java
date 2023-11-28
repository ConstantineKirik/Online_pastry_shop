package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.enums.UserStatus;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepositoryMock;

    @Test
    public void getByIdTest(){
        User userFromMock = new User();
        Mockito.when(userRepositoryMock.getReferenceById(1)).thenReturn(userFromMock);

        User user = userService.getById(1);

        assertEquals(user, userFromMock);
    }

    @Test
    public void getByUsernameTest(){
        User userFromMock = new User();
        Mockito.when(userRepositoryMock.findByUsername("Test")).thenReturn(userFromMock);

        User user = userService.getByUsername("Test");

        assertEquals(user, userFromMock);
    }

    @Test
    public void getAllByStatusTest() {
        List<User> usersFromMock = new ArrayList<>();
        Mockito.when(userRepositoryMock.findAllByStatus(UserStatus.STAFF)).thenReturn(usersFromMock);

        List<User> users = userService.getAllByStatus(UserStatus.STAFF);

        assertEquals(users, usersFromMock);
    }
}
