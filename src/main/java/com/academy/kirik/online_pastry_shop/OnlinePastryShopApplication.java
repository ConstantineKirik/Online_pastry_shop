package com.academy.kirik.online_pastry_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OnlinePastryShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinePastryShopApplication.class, args);
    }
}
