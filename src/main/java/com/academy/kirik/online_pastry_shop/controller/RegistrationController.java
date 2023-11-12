package com.academy.kirik.online_pastry_shop.controller;

import com.academy.kirik.online_pastry_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @GetMapping("/registrationUser")
    public String registrationUser() {
        return "registration";
    }

    @GetMapping("/registration")
    public String registration(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String confirmPassword,
                               @RequestParam Long mobileNumber,
                               @RequestParam String email, Model model) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }

        if (!userService.save(username, password, mobileNumber, email)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        model.addAttribute("welcome", "Welcome to the Sweet Oblivion " + username);

        return "welcome";
    }
}