package com.shop.restaurantmanagementbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedHeader("*"); // Cho phép tất cả các phương thức (GET, POST, PUT, DELETE, ...)
        config.addAllowedMethod("*"); // Cho phép tất cả các header
        config.addAllowedOrigin("http://192.168.1.13:3000");
        config.addAllowedOrigin("http://192.168.1.201:3000");
        config.addAllowedOrigin("http://localhost:3000");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
