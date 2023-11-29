package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.UserDTO;
import com.academy.kirik.online_pastry_shop.enums.Role;
import com.academy.kirik.online_pastry_shop.enums.UserStatus;
import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.model.repository.UserRepository;
import com.academy.kirik.online_pastry_shop.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImplTest {

    private UserService userService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        passwordEncoder = Mockito.mock(PasswordEncoder.class);
        userRepository = Mockito.mock(UserRepository.class);

        userService = new UserServiceImpl(userRepository, passwordEncoder);
    }

    @Test
    public void getByIdTest() {
        Integer id = 1;
        User expectedUser = User.builder().id(id).build();
        Mockito.when(userRepository.getReferenceById(Mockito.anyInt())).thenReturn(expectedUser);

        User actualUser = userService.getById(id);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void getByUsernameTest() {
        String username = "Test";
        User expectedUser = User.builder().username(username).build();
        Mockito.when(userRepository.findByUsername(Mockito.anyString())).thenReturn(expectedUser);

        User actualUser = userService.getByUsername(username);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void getAllByStatusTest() {
        List<User> expectedUsers = new ArrayList<>();
        Mockito.when(userRepository.findAllByStatus(UserStatus.STAFF)).thenReturn(expectedUsers);

        List<User> actualUsers = userService.getAllByStatus(UserStatus.STAFF);

        assertEquals(expectedUsers, actualUsers);
    }

    @Test
    void saveTrueTest() {
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

    @Test
    void saveFalseTest() {
        User user = User.builder().username("name").build();
        UserDTO userDTO = UserDTO.builder().username("name").build();
        Mockito.when(userRepository.findByUsername(Mockito.anyString())).thenReturn(user);

        boolean result = userService.save(userDTO);

        assertFalse(result);
    }

    @Test
    void checkMobileNumberTrueTest() {
        Long mobileNumber = 375297777777L;
        User user = User.builder().mobileNumber(mobileNumber).build();
        Mockito.when(userRepository.findByMobileNumber(Mockito.anyLong())).thenReturn(user);

        boolean result = userService.checkMobileNumber(mobileNumber);

        assertTrue(result);
    }

    @Test
    void checkMobileNumberFalseTest() {
        Long mobileNumber = 375297777777L;
        Mockito.when(userRepository.findByMobileNumber(Mockito.anyLong())).thenReturn(null);

        boolean result = userService.checkMobileNumber(mobileNumber);

        assertFalse(result);
    }

    @Test
    void checkEmailTrueTest() {
        String email = "test@mail.com";
        User user = User.builder().email(email).build();
        Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenReturn(user);

        boolean result = userService.checkEmail(email);

        assertTrue(result);
    }

    @Test
    void checkEmailFalseTest() {
        String email = "test@mail.com";
        Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenReturn(null);

        boolean result = userService.checkEmail(email);

        assertFalse(result);
    }

    @Test
    public void loadUserByUsernameTest() {
        String username = "Test";
        User expectedUser = User.builder().username(username).build();
        Mockito.when(userRepository.findByUsername(Mockito.anyString())).thenReturn(expectedUser);

        User actualUser = (User) userService.loadUserByUsername(username);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void loadUserByUsernameThrowsExceptionTest() {
        String username = "Test";
        Mockito.when(userRepository.findByUsername(Mockito.anyString())).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(username));
    }

    @Test
    public void loadUserByUsernameThrowsExceptionMessageTest() {
        String username = "Test";
        String message = "User" + username + " not found";
        Mockito.when(userRepository.findByUsername(Mockito.anyString())).thenReturn(null);

        UsernameNotFoundException thrown = assertThrows(UsernameNotFoundException.class, () ->
                userService.loadUserByUsername(username));

        assertEquals(message, thrown.getMessage());
    }

    @Test
    public void updateUserRoleTest() {
        User user = User.builder().id(1).role(Role.ROLE_CLIENT).build();
        Mockito.when(userRepository.getReferenceById(Mockito.anyInt())).thenReturn(user);

        userService.updateUserRole(1, Role.ROLE_ADMIN);

        assertEquals(Role.ROLE_ADMIN, user.getRole());
    }

    @Test
    public void updateUserStatusTest() {
        User user = User.builder().id(1).status(UserStatus.NEW).build();
        Mockito.when(userRepository.getReferenceById(Mockito.anyInt())).thenReturn(user);

        userService.updateUserStatus(1, UserStatus.STAFF);

        assertEquals(UserStatus.STAFF, user.getStatus());
    }

    @Test
    public void addToBlackListTest() {
        User user = User.builder().id(1).status(UserStatus.NEW).build();
        Mockito.when(userRepository.getReferenceById(Mockito.anyInt())).thenReturn(user);

        userService.updateUserStatus(1, UserStatus.BLACKLIST);

        assertEquals(UserStatus.BLACKLIST, user.getStatus());
    }
}