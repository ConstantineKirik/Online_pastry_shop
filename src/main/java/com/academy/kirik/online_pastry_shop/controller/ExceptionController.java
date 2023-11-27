package com.academy.kirik.online_pastry_shop.controller;

import com.academy.kirik.online_pastry_shop.model.entity.User;
import com.academy.kirik.online_pastry_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ExceptionController {
    private final UserService userService;

    @PostMapping(value = "/loginError")
    public String loginError(EmbeddedLdapProperties.Credential credential, Model model) {

        User user = userService.getByUsername(credential.getUsername());

        if (user == null) {
            model.addAttribute("usernameError", "Пользователя с таким именем не существует!");
            return "login";
        }

        if (!user.isAccountNonLocked()) {
            model.addAttribute("blackList", "Вы в черном списке!");
            return "login";
        }

        if (!user.getPassword().equals(credential.getPassword())) {
            model.addAttribute("passwordError", "Неверный пароль!");
            return "login";
        }

        return "login";
    }
}
