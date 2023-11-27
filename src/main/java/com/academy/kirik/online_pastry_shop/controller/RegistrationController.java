package com.academy.kirik.online_pastry_shop.controller;

import com.academy.kirik.online_pastry_shop.dto.UserDTO;
import com.academy.kirik.online_pastry_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @GetMapping(value = "/registrationUser")
    public String registrationUser(Model model) {
        model.addAttribute("registrationUser", new UserDTO());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("registrationUser") UserDTO userDTO, Model model) {

        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            model.addAttribute("passwordError", "Пароли не совпадают!");
            return "registration";
        }

        if (userService.checkMobileNumber(userDTO.getMobileNumber())) {
            model.addAttribute("mobileNumberError", "Пользователь с таким номером уже существует!");
            return "registration";
        }

        if (userService.checkEmail(userDTO.getEmail())) {
            model.addAttribute("emailError", "Пользователь с таким емайлом уже существует!");
            return "registration";
        }

        if (!userService.save(userDTO)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует!");
            return "registration";
        }

        return "redirect:/login";
    }
}