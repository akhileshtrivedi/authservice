package com.at.authservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringConfiguration {
    // It is a good practice to use a strong hashing algorithm like BCrypt to hash the passwords.
    //It is not JWT Token specific, but it is a good practice to use it.
    @Bean
    public BCryptPasswordEncoder  passwordEncoder() {
        return new BCryptPasswordEncoder(16);
    }
}
