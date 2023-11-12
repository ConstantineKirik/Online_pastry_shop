package com.academy.kirik.online_pastry_shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/loginUser").setViewName("login");
        registry.addViewController("/welcome").setViewName("welcome");
        registry.addViewController("/delivery").setViewName("delivery");
        registry.addViewController("/about_us").setViewName("about_us");
    }
}
