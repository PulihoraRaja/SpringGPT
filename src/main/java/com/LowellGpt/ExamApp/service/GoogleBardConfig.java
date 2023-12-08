package com.LowellGpt.ExamApp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pkslow.ai.GoogleBardClient;

@Configuration
public class GoogleBardConfig {

    @Bean
    public GoogleBardClient googleBardClient(@Value("${bard.api-key}") String token) {
        return new GoogleBardClient(token);
    }
}
