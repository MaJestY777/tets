package com.example.water_cloud1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCconfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/***")
                .excludePathPatterns("/login", "/login_check","/login.html");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index.html");
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/admin").setViewName("admin.html");
        registry.addViewController("/entry_add").setViewName("EntryAdd.html");
        registry.addViewController("/entry_update").setViewName("EntryUpdate.html");
        registry.addViewController("/mission_add").setViewName("MissionAdd.html");
        registry.addViewController("/mission_update").setViewName("MissionUpdate.html");
    }
}
