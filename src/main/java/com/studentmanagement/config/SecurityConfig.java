package com.studentmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Required for AuthController JWT login
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())       // Disable CSRF
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()       // Allow ALL URLs
            )
            .formLogin(login -> login.disable())   // Disable login form
            .httpBasic(basic -> basic.disable())   // Disable basic auth
            .logout(logout -> logout.disable());    // Disable logout

        return http.build();
    }
    }

