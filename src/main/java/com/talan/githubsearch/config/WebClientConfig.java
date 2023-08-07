package com.talan.githubsearch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
class WebClientConfig {

    private final String bearerToken;

    public WebClientConfig(@Value("${GITHUB_BEARER_TOKEN}") String bearerToken) {
        this.bearerToken = bearerToken;
    }

    @Bean
    WebClient.Builder webClientBuilder() {
        return WebClient
                .builder()
                .defaultHeader("Authorization", bearerToken);
    }
}