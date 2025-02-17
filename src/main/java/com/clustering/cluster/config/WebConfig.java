package com.clustering.cluster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permet à toutes les origines d'accéder à l'API
        registry.addMapping("/api/**") // Appliquer à toutes les routes commençant par /api/
                .allowedOrigins("http://localhost:3000") // Autoriser toutes les origines (CORS ouvert)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Autoriser les méthodes HTTP courantes
                .allowedHeaders("**") // Autoriser tous les en-têtes
                .allowCredentials(true); // Si vous devez envoyer des informations d'authentification (cookies, headers)
    }
}

