package com.example.buildservice.config.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
    
    @Bean
    public CustomPhysicalNamingStrategy customPhysicalNamingStrategy() {
        return new CustomPhysicalNamingStrategy();
    }
}
